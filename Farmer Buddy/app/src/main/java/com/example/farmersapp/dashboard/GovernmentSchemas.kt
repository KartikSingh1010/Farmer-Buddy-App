package com.example.farmersapp.dashboard

import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.farmersapp.R
import com.example.farmersapp.adapters.AboutCropAdapter
import com.example.farmersapp.adapters.GovtSchemeAdapter
import com.example.farmersapp.models.CropItem
import com.example.farmersapp.models.SchemeItem
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class GovernmentSchemas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_government_schemas)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<SchemeItem>()

        val db = Firebase.firestore
//        db.collection("policies")
//            .get()
//            .addOnSuccessListener { result ->
//                for (document in result) {
//                    data.add(
//                        SchemeItem(
//                            document.data["image"].toString(),
//                            document.data["name"].toString(),
//                            document.data["desc"].toString()
//
//                        )
//                    )
//                }

        data.add(
            SchemeItem(
                "https://agriculturehindi.com/wp-content/uploads/2021/07/Pradhan-Mantri-Krishi-Sinchai-Yo-1.png",
                "Pradhan Mantri Krishi Sinchai Yojana (PMKSY), ",
                        "Har Khet ko Pani \"Prime Minister Krishi Sinchayee Yojana\"\n" +
                        "\n" +
                        "Vision \n" +
                        "\n" +
                        "Ø  commitment toward conservation and management of water.\n" +
                        "\n" +
                        "Ø  Improve the water-use efficiency.\n" +
                        "\n" +
                        "Mission\n" +
                        "\n" +
                        "Ø  More crop per drop\n" +
                        "\n" +
                        "Ø  Solution on source creation and management of water.\n" +
                        "\n" +
                        "Ø  Solution about field application and activities"
            )
        )

        data.add(
            SchemeItem(
                "https://kj1bcdn.b-cdn.net/media/43026/pkvy-1.png?width=1200",
                "Paramparagat Krishi Vikas Yojana (PKVY)",
                "An initiative launched by the NDA government in 2015 \n" +
                        "\n" +
                        "Vision\n" +
                        "\n" +
                        "Ø  To promote organic farming\n" +
                        "\n" +
                        "Ø  Use of traditional resources.\n" +
                        "\n" +
                        "Mission\n" +
                        "\n" +
                        "Ø  Farmers are encouraged to form clusters or groups.\n" +
                        "\n" +
                        "Ø  The aim is to form 10,000 clusters over the coming years.\n" +
                        "\n" +
                        "Ø  To bring five lakh acres of agricultural land under organic farming.\n" +
                        "\n" +
                        "Ø  Certification costs are to be borne by the government.\n" +
                        "\n" +
                        "Ø  Each cluster or group has 50 farmers willing to take up organic farming.\n" +
                        "\n" +
                        "Ø  Each farmer who enrolls in the scheme is to be provided Rs 20000 per acre."
        ))

        data.add(
            SchemeItem("data:image/jpeg;base64,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",
                            "Pradhan Mantri Fasal Bima Yojana (PMFBY)",
                            "It is a crop insurance scheme where multiple stakeholders are integrated on a single platform.\n" +
                                    "\n" +
                                    "Vision\n" +
                                    "\n" +
                                    "Ø  To provide the farmers a stable source of income.\n" +
                                    "\n" +
                                    "Ø  Farmers need not worry about income during natural calamities.\n" +
                                    "\n" +
                                    "Mission\n" +
                                    "\n" +
                                    "Ø  Farmers to be given financial support by way of insurance.\n" +
                                    "\n" +
                                    "Ø  Farmers continue to do farming even when faced with crop loss.\n" +
                                    "\n" +
                                    "Ø  Make the farmers self-reliant\n" +
                                    "\n" +
                                    "Ø  Credit flow is ensured in case of crop loss due to pests and natural calamities.")
        )

        data.add(SchemeItem("https://tractornews.in/media/oxrn0ly2/73.png?width=1080&upscale=true&format=webp",
            "Gramin Bhandaran Yojana",
            "Under this, scheme the government aims to provide storage facilities to the farmer in rural areas.\n" +
                    "\n" +
                    "Vision\n" +
                    "\n" +
                    "Ø  Create modern storage facilities in rural areas.\n" +
                    "\n" +
                    "Ø  Farmers are encouraged to maximize their output.\n" +
                    "\n" +
                    "Mission\n" +
                    "\n" +
                    "Ø  Creating enough storage facilities.\n" +
                    "\n" +
                    "Ø  Farmers can store farm produce, processed farm produce, and agricultural inputs.\n" +
                    "\n" +
                    "Ø  Improve the marketability of farm produce.\n" +
                    "\n" +
                    "Ø  Prevent the sale of produce immediately after harvest due to distress."))

        data.add(SchemeItem("https://www.mppeb.org/wp-content/uploads/2022/09/PM-Kisan-Maan-Dhan-Yojana-Registration.jpg",
            "Pradhan Mantri Kisan Maan-Dhan Yojana (PM-KMY)",
            "This scheme is especially for farmers between the age of 18-40 years. To avail of the benefit of this scheme, the farmer has to register under the pension fund.\n" +
                    "\n" +
                    "Vision:\n" +
                    "\n" +
                    "Ø  The Welfare of small and marginal farmers\n" +
                    "\n" +
                    "Ø  Provide monthly income to farmers above 60 years of age\n" +
                    "\n" +
                    "Mission\n" +
                    "\n" +
                    "Ø  To provide a minimum monthly income of Rupees 3000 for farmers after the age of 60.\n" +
                    "\n" +
                    "Ø  The Scheme is administered through the farmers’ cooperation and welfare department of agriculture."))

        data.add(SchemeItem("https://img.jagranjosh.com/imported/images/E/GK/PM-Kisan-Samman-Nidhi-Yojana%202020.jpg",
            "PM Kisan Samman Nidhi Yojana",
            "The main objective of the scheme is to transfer an amount of Rupees 6000 to the account of farmers annually. This scheme is very helpful to all those small and marginal farmers who need to buy various farm implements and meet other agricultural expenses.\n" +
                    "\n" +
                    "Vision:\n" +
                    "\n" +
                    "Ø  The scheme is intended to make the small and marginal farmers strong.\n" +
                    "\n" +
                    "Ø  The small and marginal farmer is in a position to sustain his activities.\n" +
                    "\n" +
                    "Ø  To make the farmer attentive and active.\n" +
                    "\n" +
                    "Mission:\n" +
                    "\n" +
                    "Ø  Income support to all land-holding farmers.\n" +
                    "\n" +
                    "Ø  Ensure the sustainable growth of small and marginal farmers.\n" +
                    "\n" +
                    "Ø  Small farmers can buy various farm implements."))


        data.add(SchemeItem("https://knnindia.co.in/uploads/newsfiles/MIF-Agri-8-2-2021.jpg",
            "Micro Irrigation Fund scheme",
            "The scheme is aimed to remove the hurdles of irrigation. Most farmers are depended on rain for their crops. Through this scheme, the government aims to provide irrigation facilities to the farmers.\n" +
                    "\n" +
                    "Vision:\n" +
                    "\n" +
                    "Ø  Farmers can take up new and upcoming irrigation projects.\n" +
                    "\n" +
                    "Ø  To make the farmer self-reliant for his irrigation needs.\n" +
                    "\n" +
                    "Ø  Farmers are no longer dependent on rain only.\n" +
                    "\n" +
                    "Mission:\n" +
                    "\n" +
                    "Ø  Expand the coverage of irrigation facilities.\n" +
                    "\n" +
                    "Ø  Micro-irrigation projects are undertaken by the farmers.\n" +
                    "\n" +
                    "Ø  Micro-irrigation systems are installed throughout the country."))

        data.add(SchemeItem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTuuZtlK6ckHrxQrL0CNQKE9mB3ApD8dvwttAX1zT_fru1R7zsqU_HfbrhsyPvlVGsDU4o&usqp=CAU",
            "E-NAM",
            "E-NAM is an electronic National Agriculture Marketing portal that pans India and connects the existing mandis. The purpose is to create a pan India market for agricultural produce.\n" +
                    "\n" +
                    "Vision:\n" +
                    "\n" +
                    "Ø  Promote uniformity among agriculture markets.\n" +
                    "\n" +
                    "Ø  Eliminate the role of the middle man in agriculture markets.\n" +
                    "\n" +
                    "Ø  Offer competitive prices to farmers for their produce.\n" +
                    "\n" +
                    "Mission:\n" +
                    "\n" +
                    "Ø  Integrate all APMCs across the country.\n" +
                    "\n" +
                    "Ø  Provide an online marketing platform for agriculture.\n" +
                    "\n" +
                    "Ø  Facilities are available pan India."))

        val adapter = GovtSchemeAdapter(data)
        recyclerview.adapter = adapter
    }
//    .addOnFailureListener
//    {
//        exception ->
//        Toast.makeText(this, "$exception", Toast.LENGTH_LONG).show()
//    }

}