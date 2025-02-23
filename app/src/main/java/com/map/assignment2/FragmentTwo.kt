package com.map.assignment2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentTwo.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentTwo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_two, container, false)

        val tvUserInfo = view.findViewById<TextView>(R.id.tvUserInfo)
        val btnGoToActivityTwo = view.findViewById<Button>(R.id.btnGoToActivityTwo)

        // FragmentOne에서 전달된 데이터 받기
        val name = arguments?.getString("name") ?: "Unknown"
        val email = arguments?.getString("email") ?: "Unknown"
        val gender = arguments?.getString("gender") ?: "Unknown"
        val familyEvent = arguments?.getString("familyEvent") ?: "No"
        val terms = arguments?.getString("terms") ?: "Not Agreed"

        val userInfo = """
            Name: $name
            Email: $email
            Gender: $gender
            Family Event Emails: $familyEvent
            Terms Accepted: $terms
        """.trimIndent()

        tvUserInfo.text = userInfo

        // 버튼 클릭 시 ActivityTwo로 이동 (데이터 전달)
        btnGoToActivityTwo.setOnClickListener {
            val intent = Intent(activity, ActivityTwo::class.java).apply {
                putExtra("name", name)
            }
            startActivity(intent)
        }

        return view
    }
}
