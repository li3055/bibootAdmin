$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'user/tokeninfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '收集时间', name: 'collectDateInt', index: 'collect_date_int', width: 80 }, 			
			{ label: '', name: 'symbol', index: 'symbol', width: 80 }, 			
			{ label: '', name: 'totalApply', index: 'total_apply', width: 80 }, 			
			{ label: '', name: 'pre50Percent', index: 'pre_50_percent', width: 80 }, 			
			{ label: '', name: 'pre100Percent', index: 'pre_100_percent', width: 80 }, 			
			{ label: '', name: 'pre150Percent', index: 'pre_150_percent', width: 80 }, 			
			{ label: '', name: 'pre200Percent', index: 'pre_200_percent', width: 80 }, 			
			{ label: '', name: 'pre50D1', index: 'pre_50_d1', width: 80 }, 			
			{ label: '', name: 'pre50D3', index: 'pre_50_d3', width: 80 }, 			
			{ label: '', name: 'pre50D7', index: 'pre_50_d7', width: 80 }, 			
			{ label: '', name: 'pre50D15', index: 'pre_50_d15', width: 80 }, 			
			{ label: '', name: 'pre50D30', index: 'pre_50_d30', width: 80 }, 			
			{ label: '', name: 'pre50D45', index: 'pre_50_d45', width: 80 }, 			
			{ label: '', name: 'pre100D1', index: 'pre_100_d1', width: 80 }, 			
			{ label: '', name: 'pre100D3', index: 'pre_100_d3', width: 80 }, 			
			{ label: '', name: 'pre100D7', index: 'pre_100_d7', width: 80 }, 			
			{ label: '', name: 'pre100D15', index: 'pre_100_d15', width: 80 }, 			
			{ label: '', name: 'pre100D30', index: 'pre_100_d30', width: 80 }, 			
			{ label: '', name: 'pre100D45', index: 'pre_100_d45', width: 80 }, 			
			{ label: '', name: 'pre150D1', index: 'pre_150_d1', width: 80 }, 			
			{ label: '', name: 'pre150D3', index: 'pre_150_d3', width: 80 }, 			
			{ label: '', name: 'pre150D7', index: 'pre_150_d7', width: 80 }, 			
			{ label: '', name: 'pre150D15', index: 'pre_150_d15', width: 80 }, 			
			{ label: '', name: 'pre150D30', index: 'pre_150_d30', width: 80 }, 			
			{ label: '', name: 'pre150D45', index: 'pre_150_d45', width: 80 }, 			
			{ label: '', name: 'pre200D1', index: 'pre_200_d1', width: 80 }, 			
			{ label: '', name: 'pre200D3', index: 'pre_200_d3', width: 80 }, 			
			{ label: '', name: 'pre200D7', index: 'pre_200_d7', width: 80 }, 			
			{ label: '', name: 'pre200D15', index: 'pre_200_d15', width: 80 }, 			
			{ label: '', name: 'pre200D30', index: 'pre_200_d30', width: 80 }, 			
			{ label: '', name: 'pre200D45', index: 'pre_200_d45', width: 80 }			
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
		showList: true,
		title: null,
		tokenInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tokenInfo = {};
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
			var url = vm.tokenInfo.id == null ? "user/tokeninfo/save" : "user/tokeninfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.tokenInfo),
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
				    url: baseURL + "user/tokeninfo/delete",
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
			$.get(baseURL + "user/tokeninfo/info/"+id, function(r){
                vm.tokenInfo = r.tokenInfo;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});