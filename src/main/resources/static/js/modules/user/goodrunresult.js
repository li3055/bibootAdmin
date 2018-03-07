$(function () {

    $("#jqGrid").jqGrid({
        url: baseURL + 'user/goodrunresult/list',
        datatype: "json",
        colModel: [			
			{ label: '', name: 'strategyName', index: 'strategy_name', width: 120 },
			//{ label: '', name: 'timeStyle', index: 'time_style', width: 80 },
            { label: '', name: 'enddate', index: 'endDate', width: 100 },
            { label: '', name: 'trailingBuy', index: 'trailing_Buy', width: 50 },
            { label: '', name: 'buyValue', index: 'buy_Value', width: 50 },
            { label: '', name: 'sellValue', index: 'sell_Value', width: 50 },
            { label: '', name: 'trailingProfit', index: 'trailing_Profit', width: 50 },
            { label: '', name: 'totalProfit', index: 'total_profit', width: 80 },
            { label: '', name: 'rewardRisk', index: 'Reward_risk', width: 80 },
            { label: '', name: 'maximumDrawdown', index: 'Maximum_drawdown', width: 80 },
            { label: '', name: 'averageProfitableTrades', index: 'Average_Profitable_Trades', width: 80 },
            { label: '', name: 'numberOfTrades', index: 'Number_Of_Trades', width: 60 },
            { label: 'id', name: 'id', index: 'id', width: 50, key: true },
            { label: '', name: 'symbol', index: 'symbol', width: 70 },
            { label: '', name: 'buyAndHold', index: 'Buy_and_hold', width: 80 },
            { label: '', name: 'waveTime', index: 'wave_time', width: 40 }
			//{ label: '', name: 'startdate', index: 'startDate', width: 80 },
			//{ label: '', name: 'enddate', index: 'endDate', width: 80 },
			//{ label: '', name: 'timeWidthMin', index: 'time_width_min', width: 80 },
			//{ label: '', name: 'versionStr', index: 'version_str', width: 80 }
        ],
		viewrecords: true,
        height: 17773,
        rowNum: 500,
		rowList : [10,30,500],
        rownumbers: true,
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        multiboxonly:true,
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
            strategyName:null
        },
		showList: true,
		title: null,
		goodRunResult: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.goodRunResult = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = true;
            vm.title = "修改";
            var url1 =  baseURL +   "user/runresult/list2/"+id;

            window.open(url1, "_blank");


          //  vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.goodRunResult.id == null ? "user/goodrunresult/save" : "user/goodrunresult/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.goodRunResult),
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
				    url: baseURL + "user/goodrunresult/delete",
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
			$.get(baseURL + "user/goodrunresult/info/"+id, function(r){
                vm.goodRunResult = r.goodRunResult;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'symbol': vm.q.symbol,'strategyName':vm.q.strategyName},
                page:page
            }).trigger("reloadGrid");
		}
	}
});