package com.example.animekutv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animekutv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Anime>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addAnimeList()
        recycleViewSetting()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intenAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intenAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addAnimeList(){
        list.add(Anime("Attack On Titan S1", 25, 8.51, "Anime Attack on Titan bercerita tentang umat manusia yang dibantai sejak berabad-abad yang lalu hingga hampir punah oleh makhluk mengerikan menyerupai manusia yang disebut Titan. Hal ini memaksa manusia untuk bersembunyi dan diam dalam ketakutan di balik tembok konsentris yang sangat tinggi dan besar.", "https://cdn.myanimelist.net/images/anime/10/47347.jpg"))
        list.add(Anime("Attack on Titan Season 2", 12, 8.50, "Shingeki no Kyojin Season 2, Eren Yeager dan yang lainnya dari Korps Pelatihan ke-104 baru saja mulai menjadi anggota penuh Korps Survei. Saat mereka mempersiapkan diri untuk menghadapi para Titan sekali lagi, persiapan mereka terganggu oleh invasi Wall Rose-tetapi semuanya tidak seperti yang terlihat karena lebih banyak misteri yang terungkap. Saat Survey Corps berlomba untuk menyelamatkan tembok, mereka mengungkap lebih banyak hal tentang para Titan yang menyerang dan rahasia gelap para anggotanya.", "https://cdn.myanimelist.net/images/anime/4/84177.jpg"))
        list.add(Anime("Attack on Titan Season 3", 12, 8.62, "Setelah diselamatkan dari Colossal dan Armored Titans, Eren Yaeger mengabdikan dirinya untuk memperbaiki bentuk Titan-nya. Krista Lenz berjuang untuk menerima kehilangan temannya, Kapten Levi memilih Eren dan teman-temannya untuk membentuk skuad pribadinya yang baru, dan Komandan Erwin Smith pulih dari cederanya. Semua tampak baik-baik saja bagi para prajurit, hingga pemerintah tiba-tiba meminta hak asuh atas Eren dan Krista. Keberhasilan Korps Survei baru-baru ini telah menarik perhatian, dan wajah yang tidak asing lagi dari masa lalu Levi dikirim untuk menjemput para prajurit yang dicari. Dicari oleh pemerintah, Levi dan pasukan barunya harus menghindari musuh dengan harapan dapat menjaga Eren dan Krista tetap aman.", "https://cdn.myanimelist.net/images/anime/1173/92110.jpg"))
        list.add(Anime("Attack on Titan Season 3 Part 2", 10, 9.06, "Kembali ke Distrik Shiganshina yang compang-camping yang dulunya adalah rumahnya, Eren Yeager dan Korps menemukan kota yang anehnya tidak dihuni oleh para Titan. Bahkan setelah gerbang luar dipasang, mereka tidak menemukan perlawanan. Misi ini berjalan dengan lancar hingga Armin Arlert, yang sangat curiga dengan ketidakhadiran musuh, menemukan tanda-tanda yang mengkhawatirkan tentang skema potensial untuk melawan mereka.", "https://cdn.myanimelist.net/images/anime/1517/100633.jpg"))
        list.add(Anime("Attack on Titan: Final Season", 16, 8.81, "Gabi Braun dan Falco Grice telah berlatih seumur hidup mereka untuk mewarisi salah satu dari tujuh Titan di bawah kendali Marley dan membantu bangsa mereka membasmi para Eldian di Paradis. Namun, ketika semua tampak baik-baik saja bagi kedua kadet ini, ketenangan mereka tiba-tiba terguncang oleh kedatangan Eren Yeager dan anggota Korps Survei yang tersisa. Setelah akhirnya mencapai ruang bawah tanah keluarga Yeager dan mengetahui tentang sejarah kelam yang melingkupi para Titan, Korps Survei akhirnya menemukan jawaban yang selama ini mereka perjuangkan. Dengan kebenaran yang kini berada di tangan mereka, kelompok ini berangkat menuju dunia di luar tembok.", "https://cdn.myanimelist.net/images/anime/1000/110531.jpg"))
        list.add(Anime("One Piece Film: Gold", 1, 7.90, "Monkey D. Luffy dan Kru Topi Jerami akhirnya tiba di Gran Tesoro, sebuah kapal yang membawa kota hiburan terbesar di dunia. Karena tertarik dengan peluang mendapatkan jackpot, para kru segera menuju ke kasino. Di sana, mereka dengan cepat menemukan diri mereka dalam kemenangan beruntun, bermain dengan keberuntungan yang tampaknya tak ada habisnya. Ketika ditawari perjudian khusus oleh Gild Tesoro-penguasa kota itu sendiri- para kru setuju, memilih untuk percaya pada keberuntungan kapten mereka. Namun, ketika mereka menjadi korban penipuan yang keji, para kru segera menyadari bahwa ada sesuatu yang lebih gelap yang terjadi di bawah permukaan kota.", "https://cdn.myanimelist.net/images/anime/12/81081.jpg"))
        list.add(Anime("One Piece Film: Z", 1, 8.14, "Bajak Laut Topi Jerami memasuki lautan ganas Dunia Baru untuk mencari harta karun Raja Bajak Laut, Gol D. Roger-One Piece. Dalam perjalanan mereka, para bajak laut bertemu dengan seorang pria yang menakutkan dan kuat, mantan Laksamana Laut Z. Z dituduh telah mencuri \"Batu Dyna\", senjata yang diyakini memiliki kekuatan untuk mengguncang Dunia Baru. Markas Besar Marinir percaya bahwa Z akan menggunakannya untuk mengakhiri era bajak laut, dan dengan itu, nyawa banyak orang yang tidak bersalah. Karena takut akan peristiwa fenomenal tersebut, marinir mulai mengambil tindakan terhadap mantan laksamana tersebut.", "https://cdn.myanimelist.net/images/anime/6/44297.jpg"))
        list.add(Anime("One Piece Film: Stampede", 1, 8.23, "Monkey D. Luffy dan Topi Jerami tiba di atas kapal Sunny to the Pirates Festival, perayaan terbesar di dunia yang dibuat oleh dan untuk bajak laut. Buena Festa, penyelenggara festival, mengundang Topi Jerami dan semua kru Generasi Terburuk untuk ikut serta dalam perayaan. Memikat bahkan Shichibukai dan Marinir ke pantainya, tampaknya tidak ada bajak laut atau pelaut yang dapat menolak rahasia menarik yang disembunyikan acara ini di balik kemewahannya. Kontes festival ini sederhana: temukan salah satu harta karun yang ditinggalkan Gol D. Roger. Seiring berjalannya kompetisi, berbagai kru bajak laut bertarung satu sama lain dalam battle royale gratis-untuk-semua-sampai kemunculan bajak laut yang tak terduga mengubah permainan secara drastis.", "https://cdn.myanimelist.net/images/anime/1221/100550.jpg"))
        list.add(Anime("Black Clover", 170, 8.05, "Black Clover bercerita tentang 2 anak yatim piatu bernama Asta dan Yuno. Mereka dibesarkan bersama di gereja yang sama dan sejak itu tak terpisahkan. Sebagai anak-anak, mereka berjanji akan saling bersaing untuk melihat siapa yang akan menjadi Kaisar Magus berikutnya.", "https://cdn.myanimelist.net/images/anime/2/88336.jpg"))
        list.add(Anime("Dr. Stone", 24, 8.31, "3700 tahun setelah kilatan cahaya hijau misterius mengubah umat manusia menjadi batu, seorang remaja jenius bernama Senku Ishigami bangkit dan menemukan dirinya di dunia tempat di mana semua jejak peradaban manusia telah terkikis oleh waktu. Senku yang menyadari bahwa dirinya dibangkitkan dengan asam nitrat, menghidupkan kembali temannya yang bernama Taiju Oki dan teman sekelas mereka Yuzuriha Ogawa untuk membangun kembali peradaban mereka.", "https://cdn.myanimelist.net/images/anime/1613/102576.jpg"))
        list.add(Anime("Vinland Saga", 24, 8.73, "Thorfinn muda tumbuh besar dengan mendengarkan kisah-kisah para pelaut tua yang telah mengarungi samudra dan mencapai tempat legenda, Vinland. Tempat itu dikatakan hangat dan subur, tempat di mana tidak perlu ada pertempuran - sama sekali tidak seperti desa beku di Islandia tempat dia dilahirkan, dan tentu saja tidak seperti kehidupannya saat ini sebagai tentara bayaran. Perang adalah rumahnya sekarang. Meskipun ayahnya pernah berkata kepadanya, \"Kamu tidak punya musuh, tidak ada yang punya. Tidak ada seorang pun yang tidak boleh disakiti,\" seiring pertumbuhannya, Thorfinn tahu bahwa tidak ada yang lebih jauh dari kebenaran.\n" +
                "\n" +
                "Perang antara Inggris dan Denmark semakin memburuk setiap tahunnya. Kematian telah menjadi hal yang biasa, dan tentara bayaran Viking sangat menyukai setiap momennya. Bersekutu dengan salah satu pihak akan menyebabkan perubahan besar dalam keseimbangan kekuatan, dan para viking dengan senang hati membuat nama untuk diri mereka sendiri dan mengambil harta rampasan yang mereka peroleh di sepanjang jalan. Di tengah kekacauan ini, Thorfinn harus membalaskan dendamnya dan membunuh Askeladd, orang yang membunuh ayahnya. Satu-satunya surga bagi para viking, tampaknya, adalah era perang dan kematian yang berkecamuk.", "https://cdn.myanimelist.net/images/anime/1500/103005.jpg"))
        list.add(Anime("Vinland Saga Season 2", 24, 8.73, "Setelah kematian ayahnya dan kehancuran desanya di tangan perampok Inggris, Einar berharap untuk hidup damai bersama keluarganya di pertanian mereka yang baru dibangun kembali. Namun, takdir memiliki rencana lain: desanya kembali diserang. Einar menyaksikan tanpa daya ketika para perampok Denmark membakar lahannya dan membantai keluarganya. Penjajah menangkap Einar dan membawanya kembali ke Denmark sebagai budak.\n" +
                "\n" +
                "Einar berpegang teguh pada kata-kata terakhir ibunya untuk bertahan hidup. Dia dibeli oleh Ketil, seorang pemilik budak dan tuan tanah yang baik hati yang menjanjikan bahwa Einar bisa mendapatkan kembali kebebasannya dengan imbalan bekerja di ladang. Segera, Einar bertemu dengan rekan barunya dalam budidaya pertanian-Thorfinn, seorang budak yang murung dan melankolis. Ketika Einar dan Thorfinn bekerja sama untuk mencapai kebebasan mereka, mereka dihantui oleh dosa-dosa di masa lalu dan tipu daya di masa kini. Namun mereka terus maju, menggenggam secercah harapan, penebusan, dan kedamaian di dunia yang tidak adil dan tak kenal ampun.", "https://cdn.myanimelist.net/images/anime/1170/124312.jpg"))
        list.add(Anime("Boku no Hero Academia", 13, 7.90, "Kemunculan \"quirks,\" kekuatan super yang baru ditemukan, terus meningkat selama bertahun-tahun, dengan 80 persen umat manusia memiliki berbagai kemampuan mulai dari manipulasi elemen hingga perubahan bentuk. Hal ini membuat sisa dunia tidak berdaya sama sekali, dan Izuku Midoriya adalah salah satunya.\n" +
                "\n" +
                "Sejak kecil, siswa SMP yang ambisius ini hanya ingin menjadi pahlawan. Nasib Izuku yang tidak adil membuatnya mengagumi para pahlawan dan mencatat mereka kapan pun dia bisa. Namun, tampaknya kegigihannya membuahkan hasil: Izuku bertemu dengan pahlawan nomor satu dan idola pribadinya, All Might. Keunikan All Might adalah kemampuan unik yang dapat diwariskan, dan dia telah memilih Izuku untuk menjadi penerusnya!\n" +
                "\n" +
                "Setelah menjalani latihan yang melelahkan selama berbulan-bulan, Izuku mendaftar di SMA UA, sekolah menengah bergengsi yang terkenal dengan program pelatihan pahlawan yang luar biasa, dan siswa baru tahun ini terlihat sangat menjanjikan. Dengan teman-teman sekelasnya yang aneh namun berbakat dan ancaman yang membayangi dari sebuah organisasi jahat, Izuku akan segera belajar apa artinya menjadi seorang pahlawan.", "https://cdn.myanimelist.net/images/anime/10/78745.jpg"))
    }

    private fun recycleViewSetting() {
        binding.rvAnime.setHasFixedSize(true)
        binding.rvAnime.layoutManager = LinearLayoutManager(this)
        val animeAdapter = AnimeAdapter(list)
        binding.rvAnime.adapter = animeAdapter
    }
}