-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 13, 2019 lúc 07:42 AM
-- Phiên bản máy phục vụ: 10.1.34-MariaDB
-- Phiên bản PHP: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `thietbi`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `id` int(11) NOT NULL,
  `madonhang` int(11) NOT NULL,
  `masanpham` int(11) NOT NULL,
  `tensanpham` varchar(10000) NOT NULL,
  `giasanpham` int(11) NOT NULL,
  `soluongsanpham` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`id`, `madonhang`, `masanpham`, `tensanpham`, `giasanpham`, `soluongsanpham`) VALUES
(13, 1, 26, 'Samsung Galaxy Note 8 ( CTY )', 53670000, 3),
(14, 1, 20, 'MacBook 2016 - MLH82 New 99%', 49000000, 2),
(15, 1, 9, 'Điện thoại Iphone X', 31980000, 2),
(16, 2, 10, 'Laptop Acer Aspire A715', 59970000, 3),
(17, 2, 25, 'Samsung Galaxy S9 Plus 128GB CTY', 73470000, 3),
(18, 3, 34, 'Asus Zenbook UX331UN-EG129TS/i5-8250U', 71070000, 3),
(19, 3, 23, 'Samsung Galaxy J8 ( 2018 )', 49200000, 8),
(20, 4, 34, 'Asus Zenbook UX331UN-EG129TS/i5-8250U', 23690000, 1),
(21, 4, 34, 'Asus Zenbook UX331UN-EG129TS/i5-8250U', 23690000, 1),
(22, 5, 11, 'Laptop Acer Swift SF315', 84950000, 5),
(23, 5, 26, 'Samsung Galaxy Note 8 ( CTY )', 17890000, 1),
(24, 6, 34, 'Asus Zenbook UX331UN-EG129TS/i5-8250U', 118450000, 5),
(25, 7, 26, 'Samsung Galaxy Note 8 ( CTY )', 17890000, 1),
(26, 7, 34, 'Asus Zenbook UX331UN-EG129TS/i5-8250U', 23690000, 1),
(27, 8, 10, 'Laptop Acer Aspire A715', 19990000, 1),
(28, 8, 23, 'Samsung Galaxy J8 ( 2018 )', 12300000, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `tenkhachhang` varchar(200) NOT NULL,
  `sodienthoai` int(11) NOT NULL,
  `email` varchar(200) NOT NULL,
  `diachi` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`id`, `tenkhachhang`, `sodienthoai`, `email`, `diachi`) VALUES
(1, 'Nguyễn Văn A', 1265421555, 'anv@gmail.com', '345 Nguyễn Kiệm'),
(2, 'Nguyễn Thị B', 96545522, 'bnt@gmail.com', '568 Quang Trung'),
(3, 'Yến Hồ', 1672228122, 'hty@gmail.com', '567 Nguyễn Văn Quá'),
(4, 'Trần Văn Ánh', 123548665, 'anh.tv@gmail.com', '123 Hoàng Minh Giám'),
(5, 'Tạ Văn Bình', 964844551, 'tvbinh@gmail.com', '45 Tô Vĩnh Diện'),
(6, 'Hoàng Minh Tịnh', 1685245126, 'tinhminh@gmail.com', '09 Võ Văn Ngân'),
(7, 'Nguyễn Thúy Văn', 95897454, 'nguyentv@gmail.com', '56 Bạch Đằng'),
(8, 'Thanh', 982348766, 'ca@gmail.com', '860 XVNT');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `id` int(11) NOT NULL,
  `tenloaisanpham` varchar(200) NOT NULL,
  `hinhanhloaisanpham` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`id`, `tenloaisanpham`, `hinhanhloaisanpham`) VALUES
(1, 'Điện Thoại', 'https://cdn.pixabay.com/photo/2017/01/10/03/54/icon-1968244_960_720.png'),
(2, 'LapTop', 'http://icons.iconarchive.com/icons/custom-icon-design/flatastic-7/512/Laptop-icon.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(200) NOT NULL,
  `giasanpham` int(15) NOT NULL,
  `hinhanhsanpham` varchar(200) NOT NULL,
  `motasanpham` varchar(10000) NOT NULL,
  `idsanpham` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `giasanpham`, `hinhanhsanpham`, `motasanpham`, `idsanpham`) VALUES
(1, 'Điện thoại Iphone 6 ', 3499000, 'https://cdn.tgdd.vn/Products/Images/42/70258/iphone-6-64gb-5-400x460.png', 'Công nghệ màn hình Retina HD được mô tả bởi Phil Schiller như sau: \"Đây là màn hình tiên tiến nhất hiện nay được trang bị vào một chiếc điện thoại\". iPhone 6 sẽ có điểm ảnh nhiều hơn 38% so với iPhone 5S, trong khi iPhone 6 Plus sẽ mang đến cho bạn sự ngạc nhiên lớn đến \"không tưởng\", 185% điểm ảnh.\r\n\r\nCả hai chiếc iPhone 6 đều được tích hợp công nghệ \"Dual domain pixels\", cho phép góc nhìn của người dùng rộng mở và độ bão hòa màu sắc tốt hơn, kết hợp cùng dải màu: Full sRGB, độ sáng 500 cd/m2, trên màn hình còn có lớp phủ chống bán vân tay... Những yếu tố không thể thiếu được trên một chiếc smartphone cao cấp.', 1),
(2, 'Điện thoại Iphone 6S ', 4499000, 'https://blogs-images.forbes.com/gordonkelly/files/2016/05/Screenshot-2016-05-31-at-19.27.47.png', 'iPhone 6S là phiên bản nâng cấp của dòng iPhone 6 đã ra mắt trong năm 2014 trước đó. Và trong lễ ra mắt thế hệ iPhone tiếp theo trong năm 2015, Apple đã gây bất ngờ cho người dùng khi cho ra mắt bộ đôi iPhone 6S và iPhone 6S Plus màu vàng hồng độc đáo, lạ mắt. Cùng điểm qua những sự thay đổi của phiên bản iPhone mới qua bài viết đánh giá chi tiết iPhone 6S nhé.\r\n\r\nVẫn giữ nguyên thiết kế cũ nhưng iPhone 6S nhanh hơn 70% so với bản cũ, khả năng xử lý đồ họa nhanh hơn 90% cùng với các tính năng mới độc đáo và thú vị.', 1),
(3, 'Điện thoại Iphone 6 Plus', 5299000, 'https://cdn07.happymobile.vn/media/images/2016/11/canh-vien-iphone-6-plus.jpg', 'Đúng như các thông tin rò rỉ, Apple đã ra mắt hai chiếc iPhone mới với màn hình 4,7 và 5,5 inch, tích hợp rất nhiều tính năng được mong chờ.\r\n\r\nĐúng như những dự đoán trước đó, Apple đã ra mắt đến hai phiên bản iPhone 6 tại sự kiện diễn ra đêm 9/9 (giờ Việt Nam). Giây phút iPhone 6 xuất hiện không gây ra nhiều bất ngờ, vì cả hai model đều giống hệt với những hình ảnh đã rò rỉ trước đó. Phiên bản 4,7 inch được mang tên \"iPhone 6\", còn phiên bản 5,5 inch có tên \"iPhone 6 Plus\".', 1),
(4, 'Điện thoại Iphone 6s Plus', 6099000, 'http://tinhtemobile.vn/wp-content/uploads/2016/08/ip6s-4-mau-800x800.jpg', 'iPhone 6S plus là phiên bản phóng to của iPhone 6S với màn hình lên tới 5,5 inch. Với màn hình lớn như thế này, người dùng có thể gặp phải một vài phiền phức khi sử dụng, nhưng với một bàn tay to thì không có gì phải ngần ngại để mua chiếc 6S Plus này. Mặt khác, với màn hình to bạn sẽ được trải nghiệm những điều mà những chiếc điện thoại màn hình nhỏ không làm được. So với iPhone 6S, iPhone 6S Plus không chỉ có màn hình lớn hơn, mà độ phân giải của máy cũng lớn hơn nhiều. Viên pin của chiếc điện thoại này cũng lớn hơn so với iPhone 6S\r\n', 1),
(5, 'Điện thoại Iphone 7', 7299000, 'http://tinhtemobile.vn/wp-content/uploads/2016/09/ip7-800x800-1.jpg', 'iPhone 7 Plus là sản phẩm nhận được nhiều sự nâng cấp nhất của Apple để vượt xa người anh em iPhone 7 và trở thành thiết bị rất đáng để nâng cấp so với chiếc iPhone 6S Plus trước đó.\r\n\r\nKiểu dáng\r\nVề ngoại hình, iPhone 7 Plus vẫn được xây dựng trên nền tảng nhôm nguyên khối nhằm mang đến cảm giác cầm “sướng tay” cho người dùng. Tuy nhiên, cách thiết kế đã có chút khác biệt, đặc biệt là hai dải ăn-ten ở mặt sau được uốn cong ôm lấy phần cạnh trên và cạnh dưới tạo cảm giác liền lạc khi nhìn vào.', 1),
(6, 'Điện thoại Iphone 7 Plus', 8990000, 'https://switch.com.my/wp-content/uploads/2017/11/iphone7plus_family-1.png', 'Đến hẹn lại lên đầu tháng 9-2016, Apple tung ra bộ đôi Iphone 7 và Iphone 7 Plus với thiết kế không khác biệt nhiều so với thế hệ cũ, một trong những điểm nhấn nổi bật của bộ đôi này: nút Home cảm ứng lực, nâng cấp lên chip xử lý A10, khả năng chống nước và chống bụi hay loại bỏ cổng tai nghe 3,5mm, trang bị thêm camera kép trên bản Iphone 7 Plus ', 1),
(7, 'Điện thoại Iphone 8', 10990000, 'https://cdn.tgdd.vn/Products/Images/42/114113/iphone-8-64gb-1-400x460-1-400x460.png', 'Bằng việc thay thế mặt lưng kính, cảm giác cầm tay iPhone 8 không còn mịn như khi cầm iPhone 7 mà trơn bóng và dễ bám vân tay hơn. Nhưng bù lại đó người dùng có một thiết bị với thiết kế sang trọng và thời thượng hơn.\r\nMặt lưng kính giúp iPhone 8 được tích hợp công nghệ sạc không dây hiện đại mà người dùng mong đợi từ lâu. Ngoài ra còn là lần đầu tiên Apple trang bị công nghệ sạc pin nhanh cho iPhone.\r\n\r\nMặt trước vẫn có viền màn hình khá dầy, phím home cảm ứng lực tích hợp với cả cảm biến vân tay. iPhone 8 vẫn sở hữu màn hình 4.7 inch độ phân giải HD nhưng được Apple nâng cấp và gọi bằng cái tên Retina HD True Tone.\r\n\r\nCamera chính có độ phân giải 12 MP, khẩu độ F/1.8 cùng một vài cải tiến về hình ảnh khi chụp thiếu sáng. Ngoài ra còn nâng cấp một vài điểm như hỗ trợ quay video 4K @60fps, và nâng tiếp video 240fps lên độ phân giải 1080p.\r\n\r\nCamera trước vẫn có độ phân giải 7 MP cùng khẩu độ F/2.2.\r\n\r\nĐiểm qua cấu hình, iPhone 8 sẽ sử dụng con chip 6 nhân A11 Bionic, chip có sức mạnh cao cấp nhất tính đến thời điểm ra mắt iPhone 8, cùng 2 GB RAM. Bộ nhớ trong sẽ có 2 tuỳ chọn là 64 GB hoặc 256 GB.\r\nKết hợp cùng phiên bản iOS 11, cả iPhone 8 và 8 Plus đều được nhấn mạnh vào khả năng trình chiếu thực tế ảo AR.\r\n\r\nTuy bề ngoài không thay đổi quá nhiều nhưng với nhiều công nghệ và tính năng mới được trang bị như sạc không dây, sạc pin nhanh, hỗ trợ thực tế ảo AR tốt hơn và cấu hình mạnh mẽ hơn, iPhone 8 hứa hẹn sẽ mang đến cho người dùng cao cấp những trải nghiệm thú vị và đáng giá nhất.', 1),
(8, 'Điện thoại Iphone 8 Plus', 12990000, 'https://p1.akcdn.net/full/460174297.apple-iphone-8-plus-64gb.jpg', 'Thừa hưởng thiết kế đã đạt đến độ chuẩn mực, thế hệ iPhone 8 Plus thay đổi phong cách bóng bẩy hơn và bổ sung hàng loạt tính năng cao cấp cho trải nghiệm sử dụng vô cùng tuyệt vời.', 1),
(9, 'Điện thoại Iphone X', 15990000, 'https://cdn.fptshop.com.vn/Uploads/Originals/2017/11/24/636471207542719059_1o.png', 'Đã lâu lắm rồi Apple mới ra mắt một sản phẩm với thiết kế đột phá và liều lĩnh. Dù vấp phải khá nhiều ý kiến trái chiều nhưng cũng không thể phủ nhận độ hấp dẫn của chiếc iPhone thế hệ thứ 10 này. Công nghệ bảo mật mới, loại bỏ nút home truyền thống, camera với những tính năng độc quyền, tất cả đã khiến người dùng đứng ngồi không yên cho đến khi được trên tay.', 1),
(10, 'Laptop Acer Aspire A715', 19990000, 'https://cdn.tgdd.vn/Products/Images/44/177954/acer-aspire-a715-72g-54pc-gxbsv003-4503-600x600.jpg', 'Laptop Aspire A715 72G 54PC đến từ thương hiệu Acer với Chip Core i5, thế hệ thứ 8 kết hợp card đồ họa rời NVIDIA GeForce GTX 1050, 4GB được tích hợp cho khả năng xử lý mượt mà các tác vụ đồ họa - kĩ thuật cũng như các tựa game có cấu hình khá. Đây sẽ là chiếc máy tính đáp ứng tốt nhu cầu 2 trong 1: đồ họa kĩ thuật và kể cả nhu cầu chơi game.', 2),
(11, 'Laptop Acer Swift SF315', 16990000, 'https://cdn.tgdd.vn/UserUpload/CampaignManager/20180606/1IQSVR-800.png', 'Vẻ ngoài sang trọng, tinh tế là điểm nhấn của Swift 3. Ở phiên bản 2018, máy có thiết kế thời trang, mỏng nhẹ hơn với vân ngang sáng mịn và chất liệu nhôm nguyên khối cao cấp', 2),
(12, 'Laptop Acer Aspire E5', 15990000, 'https://cdn.tgdd.vn/Products/Images/44/172385/acer-aspire-e5-576g-7927-nxgtzsv008-ava-600x600.jpg', 'Đặc điểm nổi bật của Acer Aspire E5 576G 7927 i7 7500U/4GB/500GB/2GB 940MX/Win10/(NX.GTZSV.008)\r\n\r\nAcer Aspire E5 576G 73J8​ là phiên bản laptop có chip xử lý Core i7 thế hệ thứ 7 là sự lựa chọn cho các bạn cần một chiếc máy tính làm đồ hoạ, mạnh mẽ và nhanh nhạy.\r\nCấu hình vượt trội - Tích hợp card đồ họa với Nvidia Geforce 940MX\r\nLaptop Acer tích hợp vi xử lý Intel Core i7 Kabylake mạnh mẽ giúp máy đảm đương rất tốt các công việc hay giải trí của bạn một cách tốt nhất.\r\n\r\nCPU 2.7 GHz và có thể đẩy máy tăng tốc CPU lên tới 3.5 GHz để máy làm việc nhanh hơn. Ổ cứng HDD 500 GB, RAM DDR4 4 GB và có thể nâng cấp lên tối đa 16 GB. \r\n\r\nAcer Aspire tích hợp card đồ họa rời giúp máy có thể chiến game và chỉnh sửa hình ảnh đồ họa một cách mượt mà', 2),
(13, 'Laptop Apple Macbook Pro (2015)', 16900000, 'https://cdn.tgdd.vn/Products/Images/44/71281/apple-macbook-pro-2015-mf839zp-a-i5-5257u-8gb-128g-450x300-450x300.png', 'MacBook Pro 15 inch của Apple với màn hình Retina trở lại vào năm 2015, lần này với sức mạnh của lực lượng. Chiếc MacBook mới được cải tiến này thể hiện trackpad Force Touch tiên tiến của công ty, có thể thực hiện một loạt các lệnh nhạy áp lực. Nó cũng trang bị một GPU AMD Radeon R9 R9 M370X tùy chọn, mà Apple cho biết có thể mang đến hiệu năng đồ họa gấp 80 lần so với mẫu xe năm ngoái.\r\n\r\nNgoài những thay đổi đó, bạn sẽ nhận được bộ vi xử lý Core i7 tốc độ cao, thiết kế mỏng và chắc chắn, và màn hình Retina tuyệt đẹp đạt tiêu chuẩn với máy tính xách tay chuyên nghiệp của Apple.', 2),
(14, 'Macbook Pro Retina 2015', 23900000, 'http://www.pc-mobile.it/wp-content/uploads/2016/06/MacBook-Pro-13.jpg', 'MacBook Pro MF840 có hai 2 cổng Thunderbolt 2 tốc độ cao có thể di chuyển dữ liệu tuyệt vời với 20Gbps, hơn bốn lần so với chuẩn USB 3.0. Apple vẫn hỗ trợ USB 3.0. MacBook Pro bây giờ có hai cổng USB 3.0 , do đó bạn không còn phải mua một bộ chuyển đổi , có thể sử dụng các thiết bị USB 3.0 tuân thủ nguyên bản. Ngoài ra còn có một cổng MagSafe 2 , trong đó sử dụng một kết nối an toàn từ máy tính. Xin lưu ý rằng MagSafe 2 không tương thích với bộ điều hợp MagSafe .', 2),
(15, 'MLW82 - MacBook Pro 2016 New 98%', 41500000, 'https://img.sanhgia.com/smallimage/6D1401E254C36B813A1EC40AB8ED769FEC8C790D.jpg', 'Apple đã chính thức cho ra mắt dòng MacBook Pro 2016 với thiết kế hoàn toàn mới cùng cấu hình vô cùng mạnh mẽ. Ngoài việc mỏng nhẹ hơn, cuốn hút ảnh nhìn hơn cũng như cấu hình phần cứng mạnh mẽ. Điểm ấn tượng nhất chính là SSD tốc độ siêu nhanh với băng thông lên tới 3,1GB/s, dung lượng 2TB và nhanh hơn gấp đôi. Về tổng thể, Apple cho biết Macbook Pro 15 inch cho hiệu năng gaming cao hơn 60%, đồ họa 3D cao hơn 130% và edit video cải thiện 50%.\r\n\r\nĐặc biệt, với MacBook Pro 2016 - 15 inch, người dùng sẽ trải nghiệm sự sáng tạo Touch Bar & Force Touch Trackpad mới của Apple.', 2),
(16, 'Macbook Pro Retina - MD212 Mới 97%', 15000000, 'http://2.bp.blogspot.com/-YH8ECvf-r_s/Uq_3DChJT3I/AAAAAAAAARY/GjERVLC9avw/s1600/apple-macbook-pro-13--with-retina-display--md212--252.jpg', 'MacBook Pro Retina MD212 là dòng máy tính xách tay mới nhất của Macbook Pro, nó gây bất ngờ đối với giới công nghệ vì những cải tiến đáng kể. Màn hình rộng và có độ nét siêu cao theo chuẩn Retina. Đặc biệt về cấu hình mạnh, sở hữu bộ vi xử lý Intel Core i5 2.5GHz và có thể lên tới 3.1GHz nhờ Turbo Boost và card đồ họa Intel HD Graphics 4000.\r\n\r\n ', 2),
(19, 'MPXY2 - Macbook Pro Retina 2017 Likenew', 34500000, 'https://cdn.eglobalcentral.co.it/images/detailed/57/apple-macbook-pro-2017-13-3-retina-dual-core-t6e5dl-2.jpg', 'MPXY2 - Macbook Pro Retina 2017 13inch SSD 512GB TouchBar ( Silver ) sở hữu thiết kế mỏng hơn, nhẹ hơn. Màn hình sắc nét giúp bạn có thể trải nghiệm tốt hơn. Bàn phím cơ chế butterfly thế hệ thứ 2 và đặc biệt thanh touch bar giúp nâng cao hiệu quả xử lý công việc nhanh chóng hơn. Ngoài ra, cấu hình vô cùng mạnh mẽ để bạn có thể làm việc và giải trí một cách tốt nhất với Intel Core i5, RAM 8GB, 512GB SSD và  card Intel Iris Plus Graphics 650.', 2),
(20, 'MacBook 2016 - MLH82 New 99%', 24500000, 'https://zshop.vn/images/thumbnails/200/200/detailed/79/The_New_MacBook_2016__12inchCore_m5_RAM_8GB_SSD_512GB_(Space_grey).jpg?t=1533003443', 'MacBook 12 inch MLH82 (2016) đã chính thức được Apple ra mắt trên thị trường với 4 phiên bản màu sắc, gồm: Vàng hồng, Vàng, Xám, Bạc. Cùng với việc thêm tùy chọn màu sắc cho người dùng, MacBook MLH82 (2016) được nâng cấp mạnh mẽ về cấu hình. Sản phẩm được Apple nâng cấp lên bộ xử lý Intel Core M thế hệ thứ 6 với xung nhịp từ 1,1 Ghz cho đến 1,3 GHz. Bộ nhớ RAM 8GB sẽ nâng cấp lên tốc độ cao hơn, từ 1600 MHz lên thành 1866 MHz, kết hợp với GPU Intel HD Graphics 515 thế hệ mới mang lại tốc độ xử lý đồ họa mạnh hơn 25% so với thệ hệ trước. Và tích hợp bộ nhớ flash sử dụng giao diện PCIe nhanh hơn, giúp nâng tốc độ tổng thể của hệ thống. Bên cạnh đó, Apple cho biết thời lượng pin của MacBook này được nâng cấp so với thế hệ cũ, cho phép lướt web liên tục trong 10 giờ và xem phim liên tục trong 11 giờ.', 2),
(22, 'Samsung Galaxy S8 Plus (XT)', 11690000, 'https://vinhphatmobile.com/wp-content/uploads/2017/09/samsung-galaxy-s8-plus-600x600.jpg', 'Samsung Galaxy S8 Plus (Korea) có màn hình 6.2 được ra mắt song song với Galaxy S8.  Galaxy S8 Plus (Korea) thiết kế của tương lai với màn hình cong vô cực, có viền benzel mỏng hơn, bo tròn 4 cạnh tạo điểm nhấn; loại bỏ nút home vật lí và các nút điều hướng.\r\n\r\nTHÔNG SỐ KỸ THUẬT GALAXY S8 PLUS\r\nMàn hình: 6.2 in, Super Amoled, 1440 x 2960 px\r\nCamera chính: 12.0 Mp\r\nCamera phụ: 8.0 Mp\r\nCPU: Octa-core (4×2.35 GHz Kryo & 4×1.9 GHz Kryo)\r\nGPU: Adreno 540\r\nBộ nhớ trong: 128GB, 6GB RAM hoặc 64GB , 4GB RAM\r\nMạng di động: 2G, 3G, 4G\r\nWiFi: 802.11 a/b/g/n/ac\r\nBluetooth: v4.2\r\nGPS: A-GPS, GLONASS\r\nSim Card: 1 Sim, 1 thẻ nhớ\r\nPin: 3500 mAh, Li-Ion, không thể tháo rời\r\nThiết kế của Galaxy S8 Plus (Korea) như thế nào?\r\nĐiểm nhấn của Galaxy S8 Plus (Korea) là màn hình 6,2” tấm nền Super Amoled độ phân giải tối đa lên đến 1440X2960 Px tỉ lệ 18,5:9.\r\n\r\nGalaxy S8 Plus (Korea) có chống nước hay không?\r\nChắc chắn rồi, thiết bị được trang bị tính năng chống nước và chống bụi chuẩn IP68, cho phép máy chịu nước ở độ sâu tối đa  1,5m trong khoảng thời gian là nửa tiếng.\r\n\r\nTính năng bảo mật trên S8 Plus (Korea) có gì đặc biệt?\r\nSản phẩm được trang bị bảo mật mở khóa bằng khuôn mặt, đặc biệt là quét mống mắt với tốc độ nhanh và cực kì chính xác, tính năng này đã từng xuất hiện trên Galaxy Note 7 trước đó\r\n\r\nVề dung lượng Pin\r\nThiết bị sở hữu một viên pin có dung lượng khá ấn tượng 3500mAh, mặc dù tương đương với đời tiền nhiện S7 nhưng nhờ ứng dụng chip xử lí thông minh Exynos 8895  tám nhân cùng CPU: Octa-core (4×2.35 GHz Kryo & 4×1.9 GHz Kryo)\r\n\r\nKết luận\r\nSamsung Galaxy S8 Plus là một flagship đáng đồng tiền bát gạo đến từ ông trùm Samsung. Với thiết kế vô cực mở lối tương lai, hy vọng rằng siêu phẩm sẽ là luôn giữ ngôi vương so với các smartphone cùng tầm giá.\r\n\r\nXem chi tiết cấu hình đầy đủ tại Website của Samsung', 1),
(23, 'Samsung Galaxy J8 ( 2018 )', 6150000, 'https://vinhphatmobile.com/wp-content/uploads/2018/07/samsung-galaxy-j8-j800-5.jpg', 'Màn hình: 6.0 in, Super AMOLED , 720 x 1480 pixels\r\nCamera chính: Dual 16 MP ( f/1.7 , AF ) + 5MP (f/1.9 , depth sensor ) , LED flash\r\nCamera phụ: 16 MP ( f/1.9 ) , LED flash\r\nCPU: Chipset Qualcomm SDM450 Snapdragon 450 , Octa-core 1.8 GHz Cortex-A53\r\nBộ nhớ trong: 32 GB , 3 GB RAM , Hỗ trợ thẻ nhớ lên đến 256GB\r\nMạng di động: 2G, 3G, 4G\r\nWiFi: 802.11 a/b/g/n, WiFi Direct, hotspot\r\nBluetooth: 4.2, A2DP, LE\r\nGPS: Yes, with A-GPS, GLONASS, BDS\r\nSim Card: 2 Sim ( Nano Sim , dual stand-by )\r\nPin:Li-Ion, không thể tháo rời, Li-Ion 3500 mAh', 1),
(25, 'Samsung Galaxy S9 Plus 128GB CTY', 24490000, 'https://vinhphatmobile.com/wp-content/uploads/2018/03/product_galaxys9plus_midnightblack_01.jpg', 'Màn hình: 6.2 inch, Super Amoled, 1440 x 2960 px\r\nCamera chính: Dual 12.0 MP\r\nCamera phụ: 8.0 MP\r\nCPU: Octa-core Kryo 385 (4×2.8 GHz Cortex-A75 & 4×1.8 GHz Cortex-A55)\r\nGPU: Adreno 630\r\nBộ nhớ trong: 128GB, 6GB RAM\r\nMạng di động: 2G, 3G, 4G\r\nWiFi: 802.11 a/b/g/n/ac\r\nBluetooth: 5.0\r\nGPS: A-GPS, GLONASS\r\nSim Card: Single SIM (Nano-SIM) or Hybrid Dual SIM (Nano-SIM, dual stand-by)\r\nPin: 3500mAh, Li-ion, không thể tháo rời\r\nĐÁNH GIÁ CHI TIẾT SAMSUNG GALAXY S9 PLUS\r\nSamsung Galaxy S9 Plus đã chính thức ra mắt sau một thời gian dài rò rỉ qua sự kiện Unpacked. Nếu bạn mong muốn là một trong những người sớm sở hữu siêu phẩm này, tham gia đặt trước ở Vĩnh Phát tại đây. Còn bây giờ, chúng ta hãy cùng nhau điểm qua những nét nổi trội của flagship này nhé!\r\nThiết kế ít nhiều thay đổi so với thế hệ tiền nhiệm\r\nThoạt hình, chúng ta có thể dễ dàng nhầm lẫn giữa S9 Plus và S8 bởi thiết kế tràn viền cùng 4 góc bo cong sang trọng. Tuy nhiên khi cầm trên tay, bạn sẽ cảm nhận được độ nhám ở khung viền S9 Plus – điều không xuất hiện ở S8. Nhờ đó mà S9 Plus mang lại cảm giác cầm chắc chắn hơn. Thay đổi đặc biệt nhất ở siêu phẩm này có lẽ là phần cảm biến vân tay đã được chuyển về phía mặt sau, dưới cụm camera.\r\n\r\nCấu hình được cải tiến vượt trội\r\nGalaxy S9 Plus được Samsung trang bị con chip Qualcomm Snapdragon 845/Exynos cực kỳ mạnh mẽ, chú trọng nhiều đến trí tuệ nhân tạo AI. Thiết bị sở hữu RAM 6 GB, ROM lên đến 128 GB, đồng thời hỗ trợ bộ nhớ ngoài lên đến 400 GB. Bên cạnh đó, máy sẽ chạy trên hệ điều hành Android 8.0 Oreo.\r\n\r\nCamera “vi diệu” cùng tính năng AR Emoji “thần thánh”\r\nSamsung Galaxy S9 Plus được trang bị camera chính 12 MP cùng công nghệ dual pixel 2.0 mới mẻ. Máy có khẩu độ thay đổi tùy thuộc vào điều kiện sáng ở môi trường xung quanh. Ngoài ra, S9 Plus còn được hỗ trợ quay video slow motion tốc độ 960 fpt cùng tính năng chống rung vượt trội. Nhờ đó, người dùng dễ dàng tạo ra những thước phim cực “thần thái”.\r\n\r\nAR Emoji được cho là công cụ để cạnh tranh với Animoji của iPhone X. Với tính năng này, người dùng có thể tạo ra phiên bản “dễ thương” cho cả cơ thể, chứ không riêng chỉ khuôn mặt như của Animoji.', 1),
(26, 'Samsung Galaxy Note 8 ( CTY )', 17890000, 'https://vinhphatmobile.com/wp-content/uploads/2018/01/note-8-orchil-gray.jpg', 'Màn hình: 6.3 in, Super Amoled, 1440 x 2960 px\r\nCamera chính: Dual 12.0 Mp\r\nCamera phụ: 8.0 Mp\r\nCPU: Octa-core (4×2.35 GHz Kryo & 4×1.9 GHz Kryo)\r\nGPU: Adreno 540\r\nBộ nhớ trong: 64GB, 6GB RAM\r\nMạng di động: 2G, 3G, 4G\r\nWiFi: 802.11 a/b/g/n/ac\r\nBluetooth: v5.0\r\nGPS: A-GPS, GLONASS\r\nSim Card: 2 Sim, Micro-Sim\r\nPin: 3300 mAh, Li-Ion, không thể tháo rời', 1),
(29, 'Asus TUF FX504GD-E4571T/i5-8300H', 21290000, 'https://cdn.fptshop.com.vn/Uploads/Originals/2018/4/18/636596376810147488_Asus-TUF-FX504GD-2.png', 'Hãng CPU :	Intel\r\nCông nghệ CPU :	Core i5\r\nLoại CPU :	8300H\r\nTốc độ CPU :	2.3 GHz\r\nBộ nhớ đệm :	8 MB Cache\r\nTốc độ tối đa :	4.0 GHz\r\nBo mạch\r\nHỗ trợ RAM tối đa :	32 GB\r\nRAM\r\nDung lượng RAM :	8 GB\r\nLoại RAM :	DDR4\r\nTốc độ BUS RAM :	2666 MHz\r\nSố lượng khe RAM :	2\r\nĐĩa cứng\r\nLoại ổ đĩa :	HDD\r\nDung lượng ổ đĩa :	1 TB 5400rpm\r\nKhe cắm ổ SSD :	Có\r\nĐồ họa\r\nChipset đồ họa :	NVIDIA Geforce GTX 1050\r\nBộ nhớ đồ họa :	4 GB\r\nKiểu thiết kế đồ họa :	Card rời\r\nMàn hình\r\nKích thước màn hình :	15.6 inchs\r\nĐộ phân giải (W x H) :	1920 x 1080 Pixels\r\nCông nghệ màn hình :	FHD IPS Non-Glare LED Backlit\r\nCảm ứng :	Không\r\nÂm thanh\r\nKênh âm thanh :	7.1\r\nThông tin thêm :	DTS\r\nĐĩa quang\r\nCó sẵn đĩa quang :	Không', 2),
(30, 'HP Envy 13-ah0026TU', 21990000, 'https://cdn.fptshop.com.vn/Uploads/Originals/2017/8/16/636384743490409561_HP-Envy-13-ad076TU-1.png', 'Hãng CPU :	Intel\r\nCông nghệ CPU :	Core i5\r\nLoại CPU :	8250U\r\nTốc độ CPU :	1.60 GHz\r\nBộ nhớ đệm :	6 MB Cache\r\nTốc độ tối đa :	3.40 GHz\r\nBo mạch\r\nChipset :	Intel\r\nTốc độ Bus :	2133 MHz\r\nHỗ trợ RAM tối đa :	8 GB\r\nRAM\r\nDung lượng RAM :	8 GB\r\nLoại RAM :	LPDDR3\r\nTốc độ BUS RAM :	2133 MHz\r\nSố lượng khe RAM :	1\r\nĐĩa cứng\r\nLoại ổ đĩa :	SSD\r\nDung lượng ổ đĩa :	256 GB\r\nKhe cắm ổ SSD :	Không\r\nĐồ họa\r\nChipset đồ họa :	Intel® UHD Graphics 620\r\nBộ nhớ đồ họa :	Shared\r\nKiểu thiết kế đồ họa :	Tích hợp\r\nMàn hình\r\nKích thước màn hình :	13.3 inchs\r\nĐộ phân giải (W x H) :	1920 x 1080 Pixels\r\nCông nghệ màn hình :	FHD IPS BrightView micro-edge WLED-backlit\r\nCảm ứng :	Không\r\nÂm thanh\r\nKênh âm thanh :	Bang & Olufsen, quad speakers, HP Audio Boost\r\nThông tin thêm :	Bang & Olufsen, quad speakers, HP Audio Boost\r\nĐĩa quang\r\nCó sẵn đĩa quang :	Không', 2),
(34, 'Asus Zenbook UX331UN-EG129TS/i5-8250U', 23690000, 'https://cdn.fptshop.com.vn/Uploads/Originals/2018/8/28/636710654061483200_AsusUX331UN%20(5).png', 'Bộ xử lý\r\nHãng CPU :	Intel\r\nCông nghệ CPU :	Core™ i5\r\nLoại CPU :	8250U\r\nTốc độ CPU :	1.60 GHz\r\nBộ nhớ đệm :	6 MB Cache\r\nTốc độ tối đa :	3.40 GHz\r\nBo mạch\r\nHỗ trợ RAM tối đa :	8 GB\r\nRAM\r\nDung lượng RAM :	8 GB\r\nLoại RAM :	LPDDR3\r\nTốc độ BUS RAM :	1866 MHz\r\nSố lượng khe RAM :	1\r\nĐĩa cứng\r\nLoại ổ đĩa :	SSD\r\nDung lượng ổ đĩa :	256 GB\r\nKhe cắm ổ SSD :	Có\r\nĐồ họa\r\nChipset đồ họa :	NVIDIA GEFORCE MX150\r\nBộ nhớ đồ họa :	2 GB\r\nKiểu thiết kế đồ họa :	Card rời\r\nMàn hình\r\nKích thước màn hình :	13.3 inchs\r\nĐộ phân giải (W x H) :	1920 x 1080 Pixels\r\nCông nghệ màn hình :	FullHD Anti-Glare\r\nCảm ứng :	Không\r\nÂm thanh\r\nKênh âm thanh :	\"Built-in speaker Built-in array microphone Audio by ICEpower® harmon/ kardon\"\r\nThông tin thêm :	Không\r\nĐĩa quang\r\nCó sẵn đĩa quang :	Không', 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
