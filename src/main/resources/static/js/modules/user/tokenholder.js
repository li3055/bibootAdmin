$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'user/tokenholder/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '收集时间', name: 'collectDateInt', index: 'collect_date_int', width: 80 }, 			
			{ label: '', name: 'symbol', index: 'symbol', width: 80 }, 			
			{ label: '', name: 'address', index: 'address', width: 80 }, 			
			{ label: '', name: 'rank', index: 'rank', width: 80 }, 			
			{ label: '', name: 'percent', index: 'percent', width: 80 }, 			
			{ label: '', name: 'balance', index: 'balance', width: 80 }, 			
			{ label: '', name: 'percent1', index: 'percent_1', width: 80 }, 			
			{ label: '', name: 'percent3', index: 'percent_3', width: 80 }, 			
			{ label: '', name: 'percent7', index: 'percent_7', width: 80 }, 			
			{ label: '', name: 'percent15', index: 'percent_15', width: 80 }, 			
			{ label: '', name: 'percent30', index: 'percent_30', width: 80 }, 			
			{ label: '', name: 'percent45', index: 'percent_45', width: 80 }, 			
			{ label: '', name: 'balance1', index: 'balance_1', width: 80 }, 			
			{ label: '', name: 'balance3', index: 'balance_3', width: 80 }, 			
			{ label: '', name: 'balance7', index: 'balance_7', width: 80 }, 			
			{ label: '', name: 'balance15', index: 'balance_15', width: 80 }, 			
			{ label: '', name: 'balance30', index: 'balance_30', width: 80 }, 			
			{ label: '', name: 'balance45', index: 'balance_45', width: 80 }			
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
		tokenHolder: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tokenHolder = {};
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
			var url = vm.tokenHolder.id == null ? "user/tokenholder/save" : "user/tokenholder/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.tokenHolder),
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
				    url: baseURL + "user/tokenholder/delete",
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
			$.get(baseURL + "user/tokenholder/info/"+id, function(r){
                vm.tokenHolder = r.tokenHolder;
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