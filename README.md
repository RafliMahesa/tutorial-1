# Tugas Refleksi Pemrograman Lanjut
**Nama: Muhammad Rafli Mahesa** <br>
**NPM: 2206828140** <br>
**Kelas: B** <br>
# Module 1

## Reflection 1 <br>

1. You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. Write clean code principles and secure coding practices that have been applied to your code. If you find any mistake in your source code, please explain how to improve your code. Please write your reflection inside the repository's README.md file. <br>
 

    *Clean code principles* dan *secure coding practices* sangatlah penting untuk kode yang saya buat. Clean code principles akan membuat kode saya lebih efektif, efisien, dan tentunya tidak ambigu. Selain itu, *secure coding practices* juga sangatlah penting bagi kode saya agar tidak sembarang orang bisa menggunakan akses yang tidak semestinya, karena itu dapat merugikan semua pihak yang menggunakan *website* saya. <br>

    Dari sisi *clean code principles*, saya telah menggunakan berbagai variabel yang mudah dicerna seperti ```searched``` untuk mencari *product* berdasarkan id, lalu terdapat juga berbagai fungsi nama dan alurnya sudah sesuai. Menurut saya, kode saya tidak membutuhkan *comments* karena untuk fungsi dan *variable* yang digunakan sudah cukup jelas. Fungsi-fungsi yang saya buat juga bersifat straight-forward jadi fungsinya berguna untuk 1 tujuan masing-masing. Fungsi *delete* tentu untuk menghapus item dan edit untuk mengedit nama dan *quantity*. Namun, walaupun banyak kelebihan kode saya tentu tidak lepas dari kekurangan. Kode saya memiliki kekurangan pada tidak dihandlenya suatu error ketika pada fungsi search, idnya tidak ditemukan. Namun, saya tidak meng`handle` itu bukan karena tidak ada alasan. Menurut saya, untuk sekarang belum terdapat kasus yang dapat memanggil fungsi tersebut secara manual dari *user*. <br>

    Selanjutnya untuk *secure coding* ada beberapa kelemahan yang saya temui pada module 1, yang pertama dari *input validation* tidak ada sama sekali, contoh singkatnya adalah pada *quantity*. *Quantity* pada barang bisa dimasukkan angka negatif. Selanjutnya untuk dari sisi servernya ada kelemahan yaitu pada url yang saya buat untuk mengedit item. Pada url tersebut saya melakukan *passing* id *product* ketika ingin meng*edit* *product* sehingga id yang dipakai akan keluar dalam *url*nya. <br>

## Reflection 2 <br>

1. After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. *Code coverage is a metric that can help you understand how much of your source is tested*. If you have 100% code coverage, does that mean your code has no bugs or errors? <br>

    *Unit test* merupakan test sederhana yang berguna untuk menguji apakah program kita dapat lulus dari validasi seperti fungsi, *method*, dan *class* yang dibuat. Perasaan saya setelah membuat unit test adalah sangat senang dan tenang. Setelah membuat *unit test*, saya tidak perlu mengecek berbagai *case* secara manual, dengan unit test saya bisa mengecek hanya dengan menjalankan run semua *unit test* yang sudah dibuat. <br>

    Terkait berapa banyak batas minimum unit test yang dibuat untuk suatu program tidaklah ada standar pasti, namun menurut saya mungkin 1 test yang positif dan negative sudahlah cukup jika sudah mewakili tiap *function* atau *method* yang kita buat. Akan tetapi walaupun *test* tersebut sudah dibuat semaksimal mungkin, masih terdapat kemungkinan *edge case* lain yang terlewat karena manusia tidak lepas dari kesalahan yang mungkin terlewat. <br>

    Namun, tentunya seiring dengan banyaknya *unit test* yang meng*handle* mengecek berbagai *case* terhadap program yang kita buat, tentunya *code coverage unit test* tersebut akan semakin besar, dan tentunya program yang kita buat akan lebih aman karena dengan besarnya 
*code coverage* tersebut semakin aman juga program kita terbebas dari error. <br>

2. Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the **number of items in the product list**. You decided to create a new Java class similar to the prior functional test suites with the **same setup procedures and instance variables**. <br>
What do you think about the cleanliness of the code of the new functional test suite? Will the new code reduce the code quality? Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner! **Please write your reflection inside the repository's README.md file**. <br>

    Menurut saya, kasus diatas sangatlah mubazir. Pada kasus diatas bisa dilihat bahwa kedua functional test yang tidak jauh berbeda tersebut juga menggunakan setup procedures dan instance variable yang samma. Ini sangatlah mengotori cleanliness of the code yang sebelumnya sudah dibuat sebersih mungkin. <br>

    Issue yang bisa diberikan adalah kasus repetitif yang harus kita lakukan jikalau terdapat perubahan pada html. Pada perubahan *page* html membuat kita harus mengganti kedua setup yang bisa dibilang hampir sama pada 2 class java tersebut, padahal menurut saya terdapat solusi yang lebih baik yaitu dengan menggabungkan kedua fungsi tersebut. Dengan menggabungkan kedua fungsi tersebut setup yang dibuat tidaklah repetitif sehingga cleanliness of the code kita tetaplah terjaga. Selain itu, dengan digabungnya setup fungsi tersebut maka akan mempermudah jika terdapat pergantian elemen atau isi dari page html yang kita buat <br>

# Module 2

## Reflection 1

Link Deployment: [Eshop](https://eshop-raflimahesa.koyeb.app/)

1. List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.

    1. Pada file `productlist.html` saya menambahkan tag caption untuk mengurangi code issue. 
    2. Pada file `ProductController.java` saya menggunakan variable constant untuk string yang akan dipakai berulang.
    3. Menghilangkan modifier `public` pada semua kelas test.

2. Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons (minimum 3 sentences)!

    Menurut saya, implementasi yang saya lakukan pada workflows sudah memenuhi definisi dari CI/CD. Saya sudah membuat Continous Integration yang dimana sini untuk memastikan setiap perubahan tidak merusak fungsionalitas dan memenuhi standar kode yang sudah saya buat, selain itu saya sudah membuat Continous Delivery menangani terkait deploymment. Saya sudah membuat beberapa workflows yang menangani ci/cd, antara lain: <br>
        <br>
    a. `ci.yml`: Automatic testing ketika melakukan *push* atau *pull*. <br>
    b. `scorecard.yml` dan `sonarcloud.yml`:  Melakukan pengecekan cleanliness code. <br>
    <br>
    Selain beberapa workflow diatas, saya juga menggunakan Koyeb sebagai PaaS untuk deployment, yang dimana juga sudah mengimplementasikan beberapa CI/CD bawaan untuk automisasi proses setiap terdapat push atau pull request dari suatu branch. Berdasarkan penjelasan diatas, semoga implementasi CI/CD sudah bisa tercapai dengan baik.

# Module 3

## Reflection

1. Explain what principles you apply to your project!

    1. SRP : Saya melakukan splitting file antara `CarController` dan `ProductController` sehingga memudahkan dalam 1 file hanya terdapat 1 class controller yaitu `ProductController` serta saya membuat file baru lagi khusus `CarController`. Selain itu saya juga menerapkan SRP pada method update untuk Car. Saya mengganti for loop dalam method tersebut dengan menggunakan method findById yang sudah disediakan agar kode tidak repetitif dan mengambil pekerjaan method lain.
    2. DIP : Pada file `CarController.java` saya melakukan DIP dalam mencegah kerusakan yang terjadi jika `CarServiceImpl` mengalami perubahan, jadinya saya menggunakan interface yaitu `CarService.java` nya daripada menggunakan kelas concrete `CarServiceImpl.java`.
    3. ISP : Saya melakukan perpisahan antara interface `CarService` dan `ProductService` karena penggunaan servicenya yang berbeda. Jika saya menggabungkan kedua interfacenya lalu hanya mengimplementasikan yang dibutuhkan saja dapat menyebabkan `null` atau `throw unimplemented exception`.

2. Explain the advantages of applying SOLID principles to your project with examples.
    
    * Kode menjadi lebih aman dalam menghadapi perubahan
        * Dengan menerapkan SOLID principles tentunya kode akan lebih modular karena saya menerapkan SRP dan OCP sehingga setiap komponen dari kode saya memilki tujuan masing-masing yang jelas dan tidak merusak kode lain ketika mengalami perubahan.
    * Kode menjadi lebih maintainable 
        * Maintainability dalam pengembangan sebuah kode sangatlah penting karena kode yang maintainability tentu lebih mudah dipahami sehingga itu akan memudahkan saya jika ingin melakukan pemeliharaan dan perbaikan dalam waktu yang cukup jauh dari awal pembuatan kode. Tentunya ini juga tidak lepas dari penjelasan poin pertama bahwa kode menerapkan SOLID principles tujuan dari masing-masing komponennya sudah dipisah sehingga ini juga bisa mempercepat jika terdapat bug/error saat proses pemeliharaan dan perbaikan.
    * Kode yang lebih fleksibel dan reusable
        * Dengan menerapkan SOLID principles tentunya kode juga akan lebih fleksibel dan mudah disesuaikan dengan perubahan karena saya menerapkan LSP dan DIP karena kode saya berfokus pada abstraksi dan mengurangi ketergantungan langsung antar komponen.

3. Explain the disadvantages of not applying SOLID principles to your project with examples. 
    
    * Rumitnya kode akan membuat pekerjaan terhambat
        * Saat saya tidak menerapkan SOLID principles, kode cenderung menjadi sulit dipahami dan berantakan. Setiap fungsi atau metode mungkin memiliki tanggung jawab yang terlalu banyak, dan ini dapat membuat pekerjaan kita menjadi lebih sulit dan lambat. Bayangkan mencoba mengubah atau menambahkan fitur pada suatu kode yang tidak terstruktur dengan baik - pasti memakan waktu dan pikiran ekstra.
    * Proses modifikasi yang sulit
        * Kode yang tidak menerapkan SOLID principles bisa mempunyai kendala yang besar ketika melakukan modifikasi atau pembuatan fitur baru. Misalnya, jika saya mengubah sebuah bagian kecil dari suatu bagian kode, kita menjadi khawatir karena bagian kecil tersebut berdampak pada banyak kode lain. 
    * Terlalu berkaitnya satu kode dengan kode yang lain dapat menyebabkan kerusakan pada kode
        * Sesuai dengan Dependency Inversion, misal jika saya tidak mengikuti prinsip ini dan bergantung langsung pada implementasi spesifik, seperti CarServiceImpl, maka ketika ada perubahan dalam CarServiceImpl, misalnya, perubahan metode atau struktur kelas, itu bisa merusak file CarController. Dengan menerapkan prinsip DIP, dengan menggunakan interface CarService, saya bisa melindungi CarController dari perubahan di CarServiceImpl, meminimalkan risiko potensial kerusakan dan memudahkan perubahan di masa mendatang.

# Module 4

## Reflection

1. Reflect based on Percival (2017) proposed self-reflective questions (in “Principles and Best Practice of Testing” submodule, chapter “Evaluating Your Testing Objectives”), whether this TDD flow is useful enough for you or not. If not, explain things that you need to do next time you make more tests.

    Menurut saya, prosedur TDD sangat *useful* bagi saya karena memberi alur yang baik dalam pengerjaannya. Pada prosedur TDD, akan dibagi menjadi tiga bagian yaitu [RED], [GREEN], dan [REFACTOR]. Tentu, ini akan membantu saya dalam mengimplementasikan class karena sebelum membuat suatu class sudah di *handle* semua kasus baik yang *happy* maupun *unhappy*. Jadi, TDD sangat berguna dalam tahap pengembangan untuk memastikan kode yang lebih aman serta memudahkan proses *refactor*.

2. You have created unit tests in Tutorial. Now reflect whether your tests have successfully followed F.I.R.S.T. principle or not. If not, explain things that you need to do the next time you create more tests.

    Pada unit test yang sudah saya buat pada tutorial ini, test sudah mencukupi F.I.R.S.T principle karena algoritma yang dibuat sudah dikhususkan pada suatu method dan tidak memcampuri method lain. Pada service test, saya juga sudah menggunakan mock sehingga tidak akan mempengaruhi kode yang aslinya. Hasil dari setiap test juga dibuat assertionnya agar semua kemungkinan dapat di cek dengan cukup baik. Tentunya setiap test juga dibuat semaksimal mungkin mengcover semua kemungkinan kasus "happy" dan "unhappy" dari method yang diperiksa.