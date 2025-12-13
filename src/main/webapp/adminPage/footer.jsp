<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
		<!-- / Navbar -->

	<!-- Content wrapper -->


	<!-- Core JS -->
	<!-- build:js assets/vendor/js/core.js -->
	<script src="/Java_5/adminPage/asset/vendor/libs/jquery/jquery.js"></script>
	<script src="/Java_5/adminPage/asset/vendor/libs/popper/popper.js"></script>
	<script src="/Java_5/adminPage/asset/vendor/js/bootstrap.js"></script>
	<script
		src="/Java_5/adminPage/asset/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

	<script src="/Java_5/adminPage/asset/vendor/js/menu.js"></script>
	<!-- endbuild -->

	<!-- Vendors JS -->
	<script
		src="/Java_5/adminPage/asset/vendor/libs/apex-charts/apexcharts.js"></script>

	<!-- Main JS -->
	<script src="/Java_5/adminPage/asset/js/main.js"></script>

	<!-- Page JS -->
	<script src="/Java_5/adminPage/asset/js/dashboards-analytics.js"></script>

	<!-- Place this tag in your head or just before your close body tag. -->
	<script async defer src="https://buttons.github.io/buttons.js"></script>
	<script>
	// Khi select thay đổi -> cập nhật giá gốc, giá sale, hidden input
	function attachSelectListener(select) {
	    select.addEventListener("change", function () {

	        const row = this.closest(".product-row");

	        const originalInput = row.querySelector(".product-original-price");
	        const saleInput = row.querySelector(".product-sale-price");

	        const hiddenOriginal = row.querySelector("input[name='productOriginalPrice']");
	        const hiddenSale = row.querySelector("input[name='productPrice']");

	        const price = parseFloat(this.selectedOptions[0].getAttribute("data-price")) || 0;
	        const priceSale = parseFloat(this.selectedOptions[0].getAttribute("data-pricesale")) || 0;

	        const finalPrice = priceSale > 0 ? priceSale : price;

	        // Hiển thị lên giao diện
	        originalInput.value = price;
	        saleInput.value = finalPrice;

	        // Giá submit về server
	        hiddenOriginal.value = price;
	        hiddenSale.value = finalPrice;
	    });
	}

	// Gán sự kiện cho các select hiện có
	document.addEventListener("DOMContentLoaded", function () {
	    document.querySelectorAll(".product-select").forEach(function (select) {
	        attachSelectListener(select);
	        select.dispatchEvent(new Event("change")); // Tự chạy cho dòng có sẵn
	    });
	});

	// Thêm dòng sản phẩm mới
	document.getElementById('addProductBtn').addEventListener('click', function() {

	    var tbody = document.querySelector('#productsTable tbody');
	    var newRow = document.querySelector('.product-row').cloneNode(true);

	    // Reset select & input
	    newRow.querySelectorAll('select').forEach(s => s.selectedIndex = 0);
	    newRow.querySelectorAll('input').forEach(i => i.value = "");

	    tbody.appendChild(newRow);

	    // Gán lại event listener cho select của dòng mới
	    const newSelect = newRow.querySelector(".product-select");
	    attachSelectListener(newSelect);
	});

	// Xóa dòng
	function removeRow(btn) {
	    var tbody = document.querySelector('#productsTable tbody');
	    if (tbody.querySelectorAll('tr').length <= 1) {
	        var row = btn.closest('tr');
	        row.querySelectorAll('select').forEach(s => s.selectedIndex = 0);
	        row.querySelectorAll('input').forEach(i => i.value = "");
	        return;
	    }
	    btn.closest('tr').remove();
	}

</script>
</body>
</html>