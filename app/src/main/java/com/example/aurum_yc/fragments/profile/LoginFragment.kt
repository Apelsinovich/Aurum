package com.example.aurum_yc.fragments.profile

import android.R.attr.password
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.aurum_yc.MainMenuActivity
import com.example.aurum_yc.R
import com.example.aurum_yc.activities.EventActivity
import com.example.aurum_yc.activities.LoginActivity
import com.example.aurum_yc.fragments.events.EventActualListFragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class LoginFragment: Fragment() {

    private lateinit var etUserEMail: EditText
    private lateinit var etUserPassword: EditText
    private lateinit var btSignIn: Button
    private lateinit var btSignOut: Button
    private lateinit var pbLogin: ProgressBar
    private lateinit var auth: FirebaseAuth



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View? = inflater.inflate(R.layout.fragment_login_form, container, false)

//      [инициализация объектов UI]
        etUserEMail = v!!.findViewById(R.id.et_userEMail)
        etUserPassword = v!!.findViewById(R.id.et_userPassword)
        btSignIn = v!!.findViewById(R.id.bt_signIn)
        btSignOut = v!!.findViewById(R.id.bt_signOut)
        pbLogin = v!!.findViewById(R.id.pb_loginFragment)

//      [инициализация объекта авторизации Firebase]
        auth = FirebaseAuth.getInstance()

//      [добавление функционала на нажатие кнопки "Войти" через листенер]
        btSignIn.setOnClickListener{
            signIn(v)
        }
        btSignOut.setOnClickListener {
            signOut(v)
        }

        return v
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser

        if (currentUser == null) {
            Toast.makeText(this.context, "Юзер не обнаружен", Toast.LENGTH_SHORT)
        } else
        {
            Toast.makeText(this.context, "Юзер обнаружен", Toast.LENGTH_SHORT)
        }
    }

    private fun signIn(view: View) {

        if (!validateForm()) {
            return
        }

//      [отобразить визуализацию загрузки progressBar]
        pbLogin.visibility = View.VISIBLE

        auth.signInWithEmailAndPassword(etUserEMail.text.toString(), etUserPassword.text.toString())
            .addOnCompleteListener() {
                if (it.isSuccessful) {
                    Log.d(TAG, "signInWithEmail:success")
                    Toast.makeText(view.context, "Вход в систему успешен",
                        Toast.LENGTH_SHORT).show()
                    val user = auth.currentUser

                    var intent = Intent(view.context, MainMenuActivity::class.java)

                    intent.putExtra("Email", etUserEMail.text.toString())
                    view.context!!.startActivity(intent)

                }
                else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", it.exception)
                    Toast.makeText(view.context, "Пользователь не найден", Toast.LENGTH_SHORT).show()
                    etUserPassword.setText("")
//      [сыкрыть визуализацию загрузки rogressBar]
                    pbLogin.visibility = View.GONE
                }
            }
    }

    private fun signOut(view: View) {
        auth.signOut()
        Toast.makeText(this.context, "Выход из системы успешен", Toast.LENGTH_SHORT).show()
//        updateUI(null)
    }

    private fun updateUI(user: FirebaseUser?) {

    }

    private fun validateForm(): Boolean {
        var valid = true
        val email = etUserEMail.text.toString()
        val password = etUserPassword.text.toString()

        if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
            Toast.makeText(this.context, "Email и пароль не указаны", Toast.LENGTH_SHORT).show()
            valid = false
        } else if (TextUtils.isEmpty(email)) {
            Toast.makeText(this.context, "Email не указан", Toast.LENGTH_SHORT).show()
            valid = false
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this.context, "Пароль не указан", Toast.LENGTH_SHORT).show()
            valid = false
        }

        return valid
    }

}

