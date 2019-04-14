<?php

	require "connect.php";
	$tensp= $_POST['tensp'];
	$hinhsp=$_POST['hinhsp'];
	$giasp=$_POST['giasp'];
	$motasp=$_POST['motasp'];
	$idloaisp=$_POST['idloaisp'];

	if (strlen($tensp)>0 && strlen($giasp)>0 && strlen($hinhsp)>0 && strlen($motasp)>0 && strlen($idloaisp)>0){
		$query = "INSERT INTO sanpham VALUES (null, '$tensp',$giasp,'$hinhsp','$motasp',$idloaisp)";
		$data = mysqli_query($con,$query);
		if ($data){
			echo "OK";
		}else {
			echo "Fail";
		}
	}else{
		echo "null";
	}

?>