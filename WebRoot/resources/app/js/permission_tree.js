var permissions = [ {
	"id" : "0",
	"name" : "权限树",
	"open" : true,
	"pId" : ""
}, {
	"id" : "1",
	"name" : "用户权限管理",
	"open" : true,
	"pId" : "0"
}, {
	"id" : "2",
	"name" : "角色维护",
	"open" : true,
	"pId" : "1"
}, {
	"id" : "3",
	"name" : "查询",
	"open" : true,
	"pId" : "2"
}, {
	"id" : "4",
	"name" : "添加",
	"open" : true,
	"pId" : "2"
}, {
	"id" : "5",
	"name" : "修改",
	"open" : true,
	"pId" : "2"
}, {
	"id" : "6",
	"name" : "删除",
	"open" : true,
	"pId" : "2"
}, {
	"id" : "7",
	"name" : "分配权限",
	"open" : true,
	"pId" : "2"
}, {
	"id" : "8",
	"name" : "用户维护",
	"open" : true,
	"pId" : "1"
}, {
	"id" : "9",
	"name" : "查询",
	"open" : true,
	"pId" : "8"
}, {
	"id" : "10",
	"name" : "添加",
	"open" : true,
	"pId" : "8"
}, {
	"id" : "11",
	"name" : "修改",
	"open" : true,
	"pId" : "8"
}, {
	"id" : "12",
	"name" : "删除",
	"open" : true,
	"pId" : "8"
}, {
	"id" : "13",
	"name" : "分配角色",
	"open" : true,
	"pId" : "8"
}, {
	"id" : "14",
	"name" : "系统管理",
	"open" : true,
	"pId" : "0"
}, {
	"id" : "15",
	"name" : "系统日志",
	"open" : true,
	"pId" : "14"
}, {
	"id" : "16",
	"name" : "修改密码",
	"open" : true,
	"pId" : "14"
}, {
	"id" : "17",
	"name" : "注销登录",
	"open" : true,
	"pId" : "14"
}, {
	"id" : "80",
	"name" : "部门管理",
	"open" : true,
	"pId" : "0"
}, {
	"id" : "81",
	"name" : "查询",
	"open" : true,
	"pId" : "80"
}, {
	"id" : "82",
	"name" : "添加",
	"open" : true,
	"pId" : "80"
}, {
	"id" : "83",
	"name" : "修改",
	"open" : true,
	"pId" : "80"
}, {
	"id" : "84",
	"name" : "删除",
	"open" : true,
	"pId" : "80"
}, {
	"id" : "85",
	"name" : "岗位管理",
	"open" : true,
	"pId" : "0"
}, {
	"id" : "86",
	"name" : "查询",
	"open" : true,
	"pId" : "85"
}, {
	"id" : "87",
	"name" : "添加",
	"open" : true,
	"pId" : "85"
}, {
	"id" : "88",
	"name" : "修改",
	"open" : true,
	"pId" : "85"
}, {
	"id" : "89",
	"name" : "删除",
	"open" : true,
	"pId" : "85"
} ];

var zTree;
var setting = {
    check: {
        enable: true
    },
    view: {
        dblClickExpand: false,
        showLine: true,
        selectedMulti: false
    },
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pId",
            rootPId: "-1"
        }
    },
    callback: {
        beforeClick: function (treeId, treeNode) {
            var zTree = $.fn.zTree.getZTreeObj("tree");
            if (treeNode.isParent) {
                zTree.expandNode(treeNode);
                return false;
            } else {
                return true;
            }
        }
    }
};

function initPermissionTree(ps) {
    var t = $("#tree");
    if(ps.length > 0) {
        permissions[0].checked = true;
    }
    for(var i = 0; i < permissions.length; i ++) {
        var permission = permissions[i];
        for(var j = 0; j < ps.length; j ++) {
            if(permission.id == ps[j]) {
                permission.checked = true;
            }
        }
    }
    t = $.fn.zTree.init(t, setting, permissions);
}
function initPermissionTrees(ps,treeid) {
    var t = $("#"+treeid);
    if(ps.length > 0) {
        permissions[0].checked = true;
    }
    for(var i = 0; i < permissions.length; i ++) {
        var permission = permissions[i];
        for(var j = 0; j < ps.length; j ++) {
            if(permission.id == ps[j]) {
                permission.checked = true;
            }
        }
    }
    t = $.fn.zTree.init(t, setting, permissions);
}