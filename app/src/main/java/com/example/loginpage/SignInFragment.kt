package com.example.loginpage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginpage.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {
        lateinit var binding : FragmentSignInBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
      binding = FragmentSignInBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            binding.btnLoginS.setOnClickListener{
                val intent = Intent(activity,MainActivity::class.java)
                    startActivity(intent)
            }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SignInFragment()
            }
    }
