$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'user/linedata/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '', name: 'symbol', index: 'symbol', width: 80 }, 			
			{ label: '', name: 'timeStyle', index: 'time_style', width: 80 }, 			
			{ label: '', name: 'shortValue', index: 'short_value', width: 80 }, 			
			{ label: '', name: 'longValue', index: 'long_value', width: 80 }, 			
			{ label: '', name: 'openTimeDate', index: 'open_time_date', width: 80 }, 			
			{ label: '', name: 'startDateFrom', index: 'start_date_from', width: 80 }, 			
			{ label: '', name: 'openTime', index: 'open_time', width: 80 }, 			
			{ label: '', name: 'closeTime', index: 'close_time', width: 80 }, 			
			{ label: '', name: 'lineStyle', index: 'line_style', width: 80 }, 			
			{ label: '', name: 'shortNumber', index: 'short_number', width: 80 }, 			
			{ label: '', name: 'longNumber', index: 'long_number', width: 80 }, 			
			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: 'short/long -1', name: 'spread', index: 'spread', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
        q:{
            symbol: null,
            lineStyle:null,
            openTimeDate:null,
            startDateFrom:null
        },
		showList: true,
		title: null,
		lineData: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.lineData = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.lineData.id == null ? "user/linedata/save" : "user/linedata/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.lineData),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "user/linedata/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "user/linedata/info/"+id, function(r){
                vm.lineData = r.lineData;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'symbol': vm.q.symbol,'lineStyle':vm.q.lineStyle,'openTimeDate':vm.q.openTimeDate,'startDateFrom':vm.q.startDateFrom},
                page:page
            }).trigger("reloadGrid");
		}
	}
});