<?php

 if($_SERVER['REQUEST_METHOD']=='POST'){
 $image = $_POST['image'];
 $image_name = $_POST['imagename'];
 $trail_name = $_POST['trailname'];
 $contact_name = $_POST['contactname'];

 $binary = base64_decode($image);

 $filename = $image_name;
 $count = 0;
 while (file_exists("images/{$filename}-{$count}")){
    $count++;
 }
 $image_name = $filename."-".$count;

 $file = fopen("images/".$image_name, 'wb') or die("Error opening file");
 fwrite($file, $binary) or die("Error writing file");
 fclose($file);

 $con = mysqli_connect('localhost','birdie','storeitho','trail_pics') 
 	or die("Unable to Connect " . $con->connect_error);


 $sql = "INSERT INTO trail_pics.table (image_name, trail_name, contact_name) 
 	VALUES ('$image_name', '$trail_name', '$contact_name')";

 $stmt = mysqli_prepare($con,$sql);
 //mysqli_stmt_bind_param($stmt,"s",$image);
 mysqli_stmt_execute($stmt);


 $check = mysqli_stmt_affected_rows($stmt);
 if($check == 1){
 echo "Image Uploaded Successfully";
 }else{
 echo "Error: " . $con->error;
 }
 mysqli_close($con);
 }else{
 echo "Error";
 }


 


?>
