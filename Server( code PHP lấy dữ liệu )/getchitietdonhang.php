<?php

require "connect.php";
 
 $Email =$_POST['email'];

$mangChiTietDH= array();

$query = "SELECT ct.tensanpham as 'Tên SP', ct.soluongsanpham as 'Số Lượng', sanpham.hinhanhsanpham as 'Hình SP', (sanpham.giasanpham*ct.soluongsanpham) as 'Giá' FROM chitietdonhang ct, donhang ,sanpham WHERE sanpham.id=ct.masanpham AND ct.madonhang =donhang.id AND donhang.email='$Email'";
$data = mysqli_query($con, $query);
while ($row = mysqli_fetch_assoc($data)) {
	array_push($mangChiTietDH, new thongke(
        $row['Tên SP'],
        $row['Giá'],
        $row['Hình SP'],
        $row['Số Lượng']
               
	          
	));
}
echo json_encode($mangChiTietDH); 

 class thongke{

 	function thongke($TenSP, $GiaSP,$HinhSP,$SLSP)
	{
		$this -> TenSP = $TenSP;		
		$this -> GiaSP = $GiaSP;
        $this -> HinhSP = $HinhSP;
		$this -> SLSP = $SLSP;

	}
 }

?>