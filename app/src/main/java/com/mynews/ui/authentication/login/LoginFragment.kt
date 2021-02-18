package com.mynews.ui.authentication.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mynews.databinding.FragmentLoginBinding
import com.mynews.di.compose.ViewModelFragment
import javax.inject.Inject

class LoginFragment : ViewModelFragment() {
    @Inject
    lateinit var router: LoginContract.Router
    private val viewModel: LoginViewModel by injectActivityVIewModels()
    private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.buttonLogin.setOnClickListener {
            viewModel.login(
                binding.editEmail.editText!!.text.toString(),
                binding.editPassword.editText!!.text.toString()
            )
        }
        viewModel.toastLiveData.observe(viewLifecycleOwner, { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
        })

        viewModel.loginUserStatusLiveData.observe(viewLifecycleOwner, {
            router.goToHomePage()
        })
    }
}