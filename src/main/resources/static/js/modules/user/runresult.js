$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'user/runresult/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '', name: 'symbol', index: 'symbol', width: 80 }, 			
			{ label: '', name: 'trailingBuy', index: 'trailing_Buy', width: 80 },
			{ label: '', name: 'buyValue', index: 'buy_Value', width: 80 }, 			
			{ label: '', name: 'sellValue', index: 'sell_Value', width: 80 }, 			
			{ label: '', name: 'trailingProfit', index: 'trailing_Profit', width: 80 }, 			
			{ label: '', name: 'totalProfit', index: 'total_profit', width: 110 },
            { label: '', name: 'rewardRisk', index: 'Reward_risk', width: 110 },
            { label: '', name: 'maximumDrawdown', index: 'Maximum_drawdown', width: 80 },
            { label: '', name: 'numberOfTicks', index: 'Number_Of_Ticks', width: 80 },
            { label: '', name: 'numberOfTrades', index: 'Number_Of_Trades', width: 80 },
            { label: '', name: 'dataCount', index: 'data_count', width: 80 },
            { label: '', name: 'startdate', index: 'startDate', width: 80 },
            { label: '', name: 'enddate', index: 'endDate', width: 80 },
         //   { label: '', name: 'avgProfit', index: 'avg_profit', width: 80 },
		//	{ label: '', name: 'averageProfitableTrades', index: 'Average_Profitable_Trades', width: 80 },
		//	{ label: '', name: 'transactionCost', index: 'transaction_cost', width: 80 },
			{ label: '', name: 'buyAndHold', index: 'Buy_and_hold', width: 80 }
	//		{ label: '', name: 'strategyVsHold', index: 'strategy_vs_hold', width: 80 },
	//		{ label: '', name: 'startTime', index: 'start_time', width: 80 },
	//		{ label: '', name: 'endTime', index: 'end_time', width: 80 }
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
            trailingBuy: null,
            buyValue: null,
            sellValue: null,
            trailingProfit: null,
            startdate: null,
            enddate: null

        },
		showList: true,
		title: null,
		runResult: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.runResult = {};
		},
		update: function (event) {
            var ids = getSelectedRows();
            if(ids == null){
                return ;
            }

            confirm('确定要写入保守配置？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "user/runresult/update",
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
		saveOrUpdate: function (event) {
			var url = vm.runResult.id == null ? "user/runresult/save" : "user/runresult/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.runResult),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							//vm.reload();
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
			
			confirm('牛配置？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "user/runresult/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								//$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "user/runresult/info/"+id, function(r){
                vm.runResult = r.runResult;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'symbol': vm.q.symbol,'trailingBuy':vm.q.trailingBuy,'buyValue':vm.q.buyValue,'sellValue':vm.q.sellValue,'trailingProfit':vm.q.trailingProfit,'startdate':vm.q.startdate,'enddate':vm.q.enddate},
                page:page
            }).trigger("reloadGrid");
		}
	}
});