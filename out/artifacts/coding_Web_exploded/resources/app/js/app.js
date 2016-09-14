var means = [ {
	"Href" : "#",
	"Id" : "1",
	"Child" : [ {
		"Href" : "permission/role/getRoles",
		"Id" : "2",
		"Child" : [],
		"Name" : "角色维护"
	}, {
		"Href" : "permission/user/showUserList",
		"Id" : "8",
		"Child" : [],
		"Name" : "用户维护"
	} ],
	"Name" : "用户权限管理"
}, {
	"Href" : "#",
	"Id" : "18",
	"Child" : [ {
		"Href" : "channel/channel/showChannelList",
		"Id" : "19",
		"Child" : [],
		"Name" : "渠道商维护"
	} ],
	"Name" : "渠道商管理"
}, {
	"Href" : "#",
	"Id" : "26",
	"Child" : [ {
		"Href" : "cash/cashSystem/showCashSystemList",
		"Id" : "41",
		"Child" : [],
		"Name" : "兑奖公司维护"
	}, {
		"Href" : "cash/cashGun/showCashGunList",
		"Id" : "27",
		"Child" : [],
		"Name" : "兑奖枪维护"
	}, {
		"Href" : "cash/cashGroup/showCashGroupList",
		"Id" : "32",
		"Child" : [],
		"Name" : "兑奖组维护"
	} ],
	"Name" : "兑奖管理"
}, {
	"Href" : "",
	"Id" : "80",
	"Child" : [ {
		"Href" : "department/showList.action",
		"Id" : "81",
		"Child" : [],
		"Name" : "部门维护"
	} ],
	"Name" : "部门管理"
}, {
	"Href" : "",
	"Id" : "85",
	"Child" : [ {
		"Href" : "jobs/showList.action",
		"Id" : "86",
		"Child" : [],
		"Name" : "岗位维护"
	} ],
	"Name" : "岗位管理"
}, {
	"Href" : "",
	"Id" : "14",
	"Child" : [ {
		"Href" : "logout.action",
		"Id" : "17",
		"Child" : [],
		"Name" : "注销登录"
	} ],
	"Name" : "系统设置"
} ];

var basePath;

function init(path) {
    basePath = path;
}

function initMenu(permissions, activeId, activeChildId) {
    var menuTree = $("#menu");
    var menuTreeStr = ('<li class="header">功能菜单</li>');

    means.forEach(function (item) {
        if (permissions.indexOf(item.Id) > -1) {
            if(item.Id == activeId) {
                menuTreeStr += '<li class="treeview active">';
            } else {
                menuTreeStr += '<li class="treeview">';
            }
            menuTreeStr += '<a href="' + item.Href + '">';
            menuTreeStr += '<i class="fa fa-link"></i>';
            menuTreeStr += '<span>' + item.Name + '</span>';
            menuTreeStr += '<i class="fa fa-angle-left pull-right"></i>';
            menuTreeStr += '</a>';

            menuTreeStr += '<ul class="treeview-menu">';
            item.Child.forEach(function (childItem) {
                if (permissions.indexOf(childItem.Id) > -1) {
                    if(childItem.Id == activeChildId) {
                        menuTreeStr += '<li class="active"><a href="' + basePath + childItem.Href + '">' + childItem.Name + '</a></li>';
                    } else {
                        menuTreeStr += '<li><a href="' + basePath + childItem.Href + '">' + childItem.Name + '</a></li>';
                    }
                }
            });
            menuTreeStr += '</ul>';

            menuTreeStr += '</li>';
        }
    });
    menuTree.html(menuTreeStr);
}

function initTopRight(userName, roleName) {
    var topHtml = "";
    topHtml += '<li class="dropdown user user-menu">';
    topHtml += '<a href="#" class="dropdown-toggle" data-toggle="dropdown">';
    topHtml += '<img src="' + basePath + '/resources/lib/adminlte/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">';
    topHtml += '<span class="hidden-xs">' + userName + '</span>';
    topHtml += '</a>';
    topHtml += '<ul class="dropdown-menu">';
    topHtml += '<li class="user-header">';
    topHtml += '<img src= "' + basePath + '/resources/lib/adminlte/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">';
    topHtml += '<p>' + userName + ' - ' + roleName + '</p>';
    topHtml += '</li>';
    topHtml += '<li class="user-footer">';
    topHtml += '<div class="pull-left">';
    topHtml += '<a href="javascript:modifyPassword();" class="btn btn-default btn-flat">修改密码</a>';
    topHtml += '</div>';
    topHtml += '<div class="pull-right">';
    topHtml += '<a href="' + basePath + 'logout.action" class="btn btn-default btn-flat">注销</a>';
    topHtml += '</div>';
    topHtml += '</li>';
    topHtml += '</ul>';
    topHtml += '</li>';
    $("#topRight").html(topHtml);
}

var tips_sec = 3;

function getDialogWidth() {
	var w = 800;
	var width = $(window).width() * 0.6;
	width = width > w ? w : width;
	width = width < 450 ? $(window).width() : width;
	return width;
}

function getDialogHeight() {
	var h = 450;
	var height = $(window).height() * 0.7;
	height = height > h ? h : height;
	return height;
}

function modifyPassword(){
	var width = getDialogWidth();
	var height = getDialogHeight();
	$.dialog({content:'url:'+basePath+'modifyPassword.action',min:false,width:width,height:height,title:'修改密码',lock:true,fixed:true});
}