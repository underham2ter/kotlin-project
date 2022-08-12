package com.example.testapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.text.isDigitsOnly
import androidx.navigation.fragment.findNavController
import com.example.testapp.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        binding.calcButton.setOnClickListener {
            var str1 : String = binding.value1Text.text.toString()
            var str2 : String = binding.value2Text.text.toString()
            if (str1.isNotEmpty() && str2.isNotEmpty())
                if(str1.isDigitsOnly() && str2.isDigitsOnly()) {
                    binding.resultText.text = (str1.toInt()+str2.toInt()).toString()
                }
                else{
                    binding.resultText.text = "Type Error"
                }
            else{
                binding.resultText.text = "Input missing"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}