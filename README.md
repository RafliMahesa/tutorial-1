*Reflection* 1 <br>

1. You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. Write clean code principles and secure coding practices that have been applied to your code. If you find any mistake in your source code, please explain how to improve your code. Please write your reflection inside the repository's README.md file. <br>
 

*Clean code principles* dan *secure coding practices* sangatlah penting untuk kode yang saya buat. Clean code principles akan membuat kode saya lebih efektif, efisien, dan tentunya tidak ambigu. Selain itu, *secure coding practices* juga sangatlah penting bagi kode saya agar tidak sembarang orang bisa menggunakan akses yang tidak semestinya, karena itu dapat merugikan semua pihak yang menggunakan *website* saya. <br>

Dari sisi *clean code principles*, saya telah menggunakan berbagai variabel yang mudah dicerna seperti ```searched``` untuk mencari *product* berdasarkan id, lalu terdapat juga berbagai fungsi nama dan alurnya sudah sesuai. Menurut saya, kode saya tidak membutuhkan *comments* karena untuk fungsi dan *variable* yang digunakan sudah cukup jelas. Fungsi-fungsi yang saya buat juga bersifat straight-forward jadi fungsinya berguna untuk 1 tujuan masing-masing. Fungsi *delete* tentu untuk menghapus item dan edit untuk mengedit nama dan *quantity*. Namun, walaupun banyak kelebihan kode saya tentu tidak lepas dari kekurangan. Kode saya memiliki kekurangan pada tidak dihandlenya suatu error ketika pada fungsi search, idnya tidak ditemukan. Namun, saya tidak meng`handle` itu bukan karena tidak ada alasan. Menurut saya, untuk sekarang belum terdapat kasus yang dapat memanggil fungsi tersebut secara manual dari *user*. <br>

Selanjutnya untuk *secure coding* ada beberapa kelemahan yang saya temui pada module 1, yang pertama dari *input validation* tidak ada sama sekali, contoh singkatnya adalah pada *quantity*. *Quantity* pada barang bisa dimasukkan angka negatif. Selanjutnya untuk dari sisi servernya ada kelemahan yaitu pada url yang saya buat untuk mengedit item. Pada url tersebut saya melakukan *passing* id *product* ketika ingin meng*edit* *product* sehingga id yang dipakai akan keluar dalam *url*nya. <br>

*Reflection* 2 <br>

1. After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. *Code coverage is a metric that can help you understand how much of your source is tested*. If you have 100% code coverage, does that mean your code has no bugs or errors? <br>

*Unit test* merupakan test sederhana yang berguna untuk menguji apakah program kita dapat lulus dari validasi seperti fungsi, *method*, dan *class* yang dibuat. Perasaan saya setelah membuat unit test adalah sangat senang dan tenang. Setelah membuat *unit test*, saya tidak perlu mengecek berbagai *case* secara manual, dengan unit test saya bisa mengecek hanya dengan menjalankan run semua *unit test* yang sudah dibuat. <br>

Terkait berapa banyak batas minimum unit test yang dibuat untuk suatu program tidaklah ada standar pasti, namun menurut saya mungkin 1 test yang positif dan negative sudahlah cukup jika sudah mewakili tiap *function* atau *method* yang kita buat. Akan tetapi walaupun *test* tersebut sudah dibuat semaksimal mungkin, masih terdapat kemungkinan *edge case* lain yang terlewat karena manusia tidak lepas dari kesalahan yang mungkin terlewat. <br>

Namun, tentunya seiring dengan banyaknya *unit test* yang meng*handle* mengecek berbagai *case* terhadap program yang kita buat, tentunya *code coverage unit test* tersebut akan semakin besar, dan tentunya program yang kita buat akan lebih aman karena dengan besarnya 
*code coverage* tersebut semakin aman juga program kita terbebas dari error. <br>

2. Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the **number of items in the product list**. You decided to create a new Java class similar to the prior functional test suites with the **same setup procedures and instance variables**. <br>
What do you think about the cleanliness of the code of the new functional test suite? Will the new code reduce the code quality? Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner! **Please write your reflection inside the repository's README.md file**. <br>

Menurut saya, kasus diatas sangatlah mubazir. Pada kasus diatas bisa dilihat bahwa kedua functional test yang tidak jauh berbeda tersebut juga menggunakan setup procedures dan instance variable yang samma. Ini sangatlah mengotori cleanliness of the code yang sebelumnya sudah dibuat sebersih mungkin. <br>

Issue yang bisa diberikan adalah kasus repetitif yang harus kita lakukan jikalau terdapat perubahan pada html. Pada perubahan *page* html membuat kita harus mengganti kedua setup yang bisa dibilang hampir sama pada 2 class java tersebut, padahal menurut saya terdapat solusi yang lebih baik yaitu dengan menggabungkan kedua fungsi tersebut. Dengan menggabungkan kedua fungsi tersebut setup yang dibuat tidaklah repetitif sehingga cleanliness of the code kita tetaplah terjaga. Selain itu, dengan digabungnya setup fungsi tersebut maka akan mempermudah jika terdapat pergantian elemen atau isi dari page html yang kita buat<br>


