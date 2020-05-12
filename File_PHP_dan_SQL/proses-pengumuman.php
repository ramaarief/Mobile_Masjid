<?php

include("config.php");

	$id_pengumuman = $_POST['id_pengumuman'];
	$judul_pengumuman = $_POST['judul_pengumuman'];
	$isi_pengumuman = $_POST['isi_pengumuman'];
	$aktif = $_POST['aktif'];

	$sql = "UPDATE pengumuman_masjid SET judul_pengumuman='$judul_pengumuman', isi_pengumuman='$isi_pengumuman', aktif='$aktif' WHERE id_pengumuman=13 ";
	$query = mysqli_query($db, $sql);

	if ($query) {
		# code...
	}else{
		die("Gagal menyimpan perubahan...");
	}

?>
