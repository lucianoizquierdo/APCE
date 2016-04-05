<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>

<script type="text/javascript">
	
</script>



</head>
<body>
	<div>
		<table>
			<tr>
				<td>hola</td>
			</tr>
			<tr></tr>
		</table>
	</div>
	<div>
	<script type="text/javascript">
	Ext.define('KitchenSink.view.grid.ArrayGrid', {
	    extend: 'Ext.grid.Panel',
	    requires: [
	        'Ext.grid.column.Action'
	    ],
	    xtype: 'array-grid',
	    store: 'Companies',
	    stateful: true,
	    collapsible: true,
	    multiSelect: true,
	    stateId: 'stateGrid',
	    height: 350,
	    title: 'Array Grid',
	    viewConfig: {
	        stripeRows: true,
	        enableTextSelection: true
	    },

	    initComponent: function () {
	        this.width = 650;
	        this.columns = [
	            {
	                text     : 'Company',
	                flex     : 1,
	                sortable : false,
	                dataIndex: 'company'
	            },
	            {
	                text     : 'Price',
	                width    : 75,
	                sortable : true,
	                renderer : 'usMoney',
	                dataIndex: 'price'
	            },
	            {
	                text     : 'Change',
	                width    : 80,
	                sortable : true,
	                renderer : function(val) {
	                    if (val > 0) {
	                        return '<span style="color:green;">' + val + '</span>';
	                    } else if (val < 0) {
	                        return '<span style="color:red;">' + val + '</span>';
	                    }
	                    return val;
	                },
	                dataIndex: 'change'
	            },
	            {
	                text     : '% Change',
	                width    : 100,
	                sortable : true,
	                renderer : function(val) {
	                    if (val > 0) {
	                        return '<span style="color:green;">' + val + '%</span>';
	                    } else if (val < 0) {
	                        return '<span style="color:red;">' + val + '%</span>';
	                    }
	                    return val;
	                },
	                dataIndex: 'pctChange'
	            },
	            {
	                text     : 'Last Updated',
	                width    : 115,
	                sortable : true,
	                renderer : Ext.util.Format.dateRenderer('m/d/Y'),
	                dataIndex: 'lastChange'
	            },
	            {
	                menuDisabled: true,
	                sortable: false,
	                xtype: 'actioncolumn',
	                width: 50,
	                items: [{
	                    iconCls: 'sell-col',
	                    tooltip: 'Sell stock',
	                    handler: function(grid, rowIndex, colIndex) {
	                        var rec = grid.getStore().getAt(rowIndex);
	                        Ext.Msg.alert('Sell', 'Sell ' + rec.get('company'));
	                    }
	                }, {
	                    getClass: function(v, meta, rec) {
	                        if (rec.get('change') < 0) {
	                            return 'alert-col';
	                        } else {
	                            return 'buy-col';
	                        }
	                    },
	                    getTip: function(v, meta, rec) {
	                        if (rec.get('change') < 0) {
	                            return 'Hold stock';
	                        } else {
	                            return 'Buy stock';
	                        }
	                    },
	                    handler: function(grid, rowIndex, colIndex) {
	                        var rec = grid.getStore().getAt(rowIndex),
	                            action = (rec.get('change') < 0 ? 'Hold' : 'Buy');

	                        Ext.Msg.alert(action, action + ' ' + rec.get('company'));
	                    }
	                }]
	            }
	        ];

	        this.callParent();
	    }
	});
	</script>
	
	</div>
</body>
</html>