package com.mynews.ui.authentication.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mynews.databinding.FragmentRegisterBinding
import com.mynews.di.compose.ViewModelFragment
import javax.inject.Inject

class RegisterFragment : ViewModelFragment() {

    @Inject
    lateinit var router: RegisterContract.Router
    private lateinit var binding: FragmentRegisterBinding
    private val registerViewModel: RegisterViewModel by injectActivityVIewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.buttonRegister.setOnClickListener {
            registerViewModel.register(
                binding.editName.editText!!.text.toString(),
                binding.editEmail.editText!!.text.toString(),
                binding.editPassword.editText!!.text.toString(),
                binding.editConfirmPassword.editText!!.text.toString()
            )
        }

        registerViewModel.toastLiveData.observe(viewLifecycleOwner, { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
        })

        registerViewModel.createdUserStatusLiveData.observe(viewLifecycleOwner, {
            router.goToHomepage()
        })
    }
}