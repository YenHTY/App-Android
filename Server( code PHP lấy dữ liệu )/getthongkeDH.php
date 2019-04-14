<?php

require "connect.php";
 
$mangthongkedh= array();
$query = "SELECT  tenkhachhang, sodienthoai, email, diachi FROM donhang ";
$data = mysqli_query($con, $query);
while ($row = mysqli_fetch_assoc($data)) {
	array_push($mangthongkedh, new thongke(
        $row['tenkhachhang'],
        $row['sodienthoai'],
        $row['email'],
        $row['diachi']
	
          
	));
}
echo json_encode($mangthongkedh); 

 class thongke{

 	function thongke($tenkhachhang, $sodienthoai,$email,$diachi)
	{
		$this -> tenkhachhang = $tenkhachhang;
		$this -> sodienthoai = $sodienthoai;
		$this -> email = $email; 
		$this -> diachi = $diachi; 

	
	}
 }

?>