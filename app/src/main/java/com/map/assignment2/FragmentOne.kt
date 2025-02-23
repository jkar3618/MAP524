package com.map.assignment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentOne.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentOne : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_one, container, false)

        val etName = view.findViewById<EditText>(R.id.etName)
        val etEmail = view.findViewById<EditText>(R.id.etEmail)
        val rgGender = view.findViewById<RadioGroup>(R.id.rgGender)
        val switchFamilyEvent = view.findViewById<Switch>(R.id.switchFamilyEvent)
        val cbTerms = view.findViewById<CheckBox>(R.id.cbTerms)
        val btnRegister = view.findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()

            // 선택된 성별 가져오기
            val selectedGenderId = rgGender.checkedRadioButtonId
            val gender = when (selectedGenderId) {
                R.id.rbMale -> "Male"
                R.id.rbFemale -> "Female"
                else -> "Not specified"
            }

            // Switch 및 CheckBox 상태 가져오기
            val familyEvent = if (switchFamilyEvent.isChecked) "Yes" else "No"
            val termsAccepted = if (cbTerms.isChecked) "Agreed" else "Not Agreed"

            // FragmentTwo로 데이터 전달
            val bundle = Bundle().apply {
                putString("name", name)
                putString("email", email)
                putString("gender", gender)
                putString("familyEvent", familyEvent)
                putString("terms", termsAccepted)
            }

            val fragmentTwo = FragmentTwo()
            fragmentTwo.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragmentTwo)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
