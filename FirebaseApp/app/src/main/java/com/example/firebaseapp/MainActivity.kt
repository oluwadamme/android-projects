package com.example.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var textView:TextView=findViewById(R.id.text_view)

        // Realtime database
//        database = Firebase.database.reference
//
//        // Write data to db
//        database.child("price").setValue("$1920")
//        database.child("users").child("userId332").setValue("user")
//        // read data
//        val postListner=object :ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val price=snapshot.value.toString()
//                textView.text=price
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//
//        }
//        database.child("price").addValueEventListener(postListner)
        // Firestore
        val db = Firebase.firestore
        // creating collection: "Users"
        val userCollection=db.collection("Users")
        // creating documents
        val user1= hashMapOf(
            "fname" to "Dammy",
            "lname" to "John",
            "born" to "1980"
        )
        val user2= hashMapOf(
            "fname" to "John",
            "lname" to "Doe",
            "born" to "1930"
        )
        // writing data in document
        userCollection.document("user1").set(user1)
        userCollection.document("user2").set(user2)

//        // fetching data from document
//        val docRef= db.collection("Users").document("user2")
//
//        docRef.get().addOnSuccessListener { document ->
//            if (document!=null){
//                textView.text= "${document.data?.get("lname")}"
//            }
//        }
        // fetching all documents from collection
//        db.collection("Users").get().addOnSuccessListener { result ->
//            for (doc in result){
//                textView.append("${doc.data}\n")
//            }
//        }
        // updating document
        db.collection("Users").document("user1").update("born",1982)
    }
}