<script src="<%=basePath%>resources/lib/adminlte/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script src="<%=basePath%>resources/lib/adminlte/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=basePath%>resources/lib/adminlte/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>resources/lib/adminlte/plugins/fastclick/fastclick.min.js"></script>
<script src="<%=basePath%>resources/lib/adminlte/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="<%=basePath%>resources/lib/adminlte/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="<%=basePath%>resources/lib/adminlte/plugins/lhgdialog/lhgdialog.min.js?skin=default"></script>
<script src="<%=basePath%>resources/lib/twbs-pagination/jquery.twbsPagination.js"></script>
<script src="<%=basePath%>resources/lib/date_convert.js"></script>
<script src="<%=basePath%>resources/lib/adminlte/dist/js/app.min.js"></script>
<script src="<%=basePath%>resources/app/js/app.js"></script>

<script>
	var pagination;
    var tableBody;
    var currentPage=1;
    var pageSize=10;
    
    function initList() {
        $('#list').DataTable({
            "paging": false,
            "lengthChange": false,
            "searching": false,
            "ordering": false,
            "info": false,
            "autoWidth": false
		});
		tableBody = $("#table_body");
	}

	function initPage(totalCount, totalPages) {
		var visiblePageLinks = totalPages < 10 ? totalPages : 10;
		pagination = $('#pagination').twbsPagination({
			totalCount : totalCount,
			totalPages : totalPages,
			visiblePages : visiblePageLinks,
			onPageClick : function(event, page) {
				//if(page == 1) return;
				currentPage = page;
				getData(page);
			}
		});
	}

	function getData(currentPage) {
		$.ajax({
			type : "post",
			url : url,
			data : {
				currentPage : currentPage,
				pageSize : pageSize
			},
			cache : false,
			dataType : "json",
			success : function(data) {
				//if (currentPage == 1) {
				//initList();
				initPage(data.totalCount, data.totalPages);
				//}
				setData(data);
			}
		});
	}

</script>
