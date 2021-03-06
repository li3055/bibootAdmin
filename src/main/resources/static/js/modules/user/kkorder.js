$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'user/kkorder/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '', name: 'symbol', index: 'symbol', width: 80 }, 			
			{ label: '', name: 'orderId', index: 'order_id', width: 80 }, 			
			{ label: '', name: 'price', index: 'price', width: 80 }, 			
			{ label: '', name: 'orderType', index: 'order_type', width: 80 }, 			
			{ label: '', name: 'backContent', index: 'back_content', width: 80 }, 			
			{ label: '', name: 'allVolum', index: 'all_volum', width: 80 }, 			
			{ label: '', name: 'tradedVolum', index: 'traded_volum', width: 80 }, 			
			{ label: '', name: 'status', index: 'status', width: 80 }, 			
			{ label: '', name: 'amount', index: 'amount', width: 80 }, 			
			{ label: '', name: 'openDate', index: 'open_date', width: 80 }, 			
			{ label: '', name: 'closeDate', index: 'close_date', width: 80 }, 			
			{ label: '', name: 'profitDataId', index: 'profit_data_id', width: 80 }, 			
			{ label: '', name: 'insertTime', index: 'insert_time', width: 80 }, 			
			{ label: '', name: 'updateTime', index: 'update_time', width: 80 }, 			
			{ label: '', name: 'unTradeVolum', index: 'un_trade_volum', width: 80 }, 			
			{ label: '', name: 'dcaCount', index: 'dca_count', width: 80 }, 			
			{ label: '', name: 'strategy', index: 'strategy', width: 80 }, 			
			{ label: '', name: 'mark1', index: 'mark1', width: 80 }, 			
			{ label: '', name: 'mark2', index: 'mark2', width: 80 }, 			
			{ label: '', name: 'mark3', index: 'mark3', width: 80 }, 			
			{ label: '', name: 'mark4', index: 'mark4', width: 80 }			
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
		kkOrder: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.kkOrder = {};
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
			var url = vm.kkOrder.id == null ? "user/kkorder/save" : "user/kkorder/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.kkOrder),
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
				    url: baseURL + "user/kkorder/delete",
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
			$.get(baseURL + "user/kkorder/info/"+id, function(r){
                vm.kkOrder = r.kkOrder;
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