<?php

require "connect.php";
 
 $Email =  $_POST['email'];

$mangChiTietDH= array();

$query = "SELECT  SUM(ct.giasanpham*ct.soluongsanpham) as 'Giá' FROM chitietdonhang ct, donhang ,sanpham WHERE sanpham.id=ct.masanpham AND ct.madonhang =donhang.id AND donhang.email='$Email'";
$data = mysqli_query($con, $query);
while ($row = mysqli_fetch_assoc($data)) {
	array_push($mangChiTietDH, new thongke(       
       
        $row['Giá']     
               	          
       	));
}
echo json_encode($mangChiTietDH); 

 class thongke{

 	function thongke( $GiaSP)
	{				
		$this -> GiaSP = $GiaSP;        

	}
 }

?>