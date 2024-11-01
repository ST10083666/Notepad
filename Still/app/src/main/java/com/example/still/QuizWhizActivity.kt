package com.example.still

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.still.databinding.ActivityQuizWhizBinding
import android.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class QuizWhizActivity : BaseActivity() {

    private lateinit var binding: ActivityQuizWhizBinding
    private var selectedMood: String? = null

    private val questions = arrayOf(getString(R.string.question_1),
        getString(R.string.question_2),
        getString(R.string.question_3),
        getString(R.string.question_4),
        getString(R.string.question_5),
        getString(R.string.question_6),
        getString(R.string.question_7),
        getString(R.string.question_8),
        getString(R.string.question_9),
        getString(R.string.question_10),
        getString(R.string.question_11),
        getString(R.string.question_12),
        getString(R.string.question_13),
        getString(R.string.question_14),
    )

    private val options = arrayOf(
        arrayOf(getString(R.string.option_1_q1), getString(R.string.option_2_q1), getString(R.string.option_3_q1)), //1
        arrayOf(getString(R.string.option_1_q2), getString(R.string.option_2_q2), getString(R.string.option_3_q2)), //2
        arrayOf(getString(R.string.option_1_q3), getString(R.string.option_2_q3), getString(R.string.option_3_q3)), //3
        arrayOf(getString(R.string.option_1_q4), getString(R.string.option_2_q4), getString(R.string.option_3_q4)), //4
        arrayOf(getString(R.string.option_1_q5), getString(R.string.option_2_q5), getString(R.string.option_3_q5)), //5
        arrayOf(getString(R.string.option_1_q6), getString(R.string.option_2_q6), getString(R.string.option_3_q6)), //6
        arrayOf(getString(R.string.option_1_q7), getString(R.string.option_2_q7), getString(R.string.option_3_q7)), //7
        arrayOf(getString(R.string.option_1_q8), getString(R.string.option_2_q8), getString(R.string.option_3_q8)), //8
        arrayOf(getString(R.string.option_1_q9), getString(R.string.option_2_q9), getString(R.string.option_3_q9)), //9
        arrayOf(getString(R.string.option_1_q10), getString(R.string.option_2_q10), getString(R.string.option_3_q10)), //10
        arrayOf(getString(R.string.option_1_q11), getString(R.string.option_2_q11), getString(R.string.option_3_q11)), //11
        arrayOf(getString(R.string.option_1_q12), getString(R.string.option_2_q12), getString(R.string.option_3_q12)), //12
        arrayOf(getString(R.string.option_1_q13), getString(R.string.option_2_q13), getString(R.string.option_3_q13)), //13
        arrayOf(getString(R.string.option_1_q14), getString(R.string.option_2_q14), getString(R.string.option_3_q14)) //14
    )

    private val correctAnswers = arrayOf(0,1,2,0,0,1,2,0,1,0,2,1,0,1)

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizWhizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ///// MOOD TRACKER //////
        // showMoodTrackerDialog()
        ///////////////

        displayQuestion()

        binding.option1Button.setOnClickListener{
            checkAnswer(0)
        }

        binding.option2Button.setOnClickListener{
            checkAnswer(1)
        }

        binding.option3Button.setOnClickListener{
            checkAnswer(2)
        }

        binding.restartButton.setOnClickListener{
            restartQuiz()
        }
    }

    private fun correctButtonColours(buttonIndex: Int) {
        when(buttonIndex){
            0 -> binding.option1Button.setBackgroundColor(Color.GREEN)
            1 -> binding.option2Button.setBackgroundColor(Color.GREEN)
            2 -> binding.option3Button.setBackgroundColor(Color.GREEN)
        }
    }

    private fun wrongButtonColours(buttonIndex: Int) {
        when(buttonIndex){
            0 -> binding.option1Button.setBackgroundColor(Color.RED)
            1 -> binding.option2Button.setBackgroundColor(Color.RED)
            2 -> binding.option3Button.setBackgroundColor(Color.RED)
        }
    }

    private fun resetButtonColours() {
        binding.option1Button.setBackgroundColor(Color.rgb(50,59,96))
        binding.option2Button.setBackgroundColor(Color.rgb(50,59,96))
        binding.option3Button.setBackgroundColor(Color.rgb(50,59,96))
    }

    private fun showResults(){
        binding.scoreText.text = getString(R.string.score_text, score, questions.size)
        binding.restartButton.isEnabled = true
    }

    private fun disableButtons() {
        binding.option1Button.isEnabled = false
        binding.option2Button.isEnabled = false
        binding.option3Button.isEnabled = false
    }

    private fun enableButtons() {
        binding.option1Button.isEnabled = true
        binding.option2Button.isEnabled = true
        binding.option3Button.isEnabled = true
    }

    private fun displayQuestion(){
        binding.questionText.text = questions[currentQuestionIndex]
        binding.option1Button.text = options[currentQuestionIndex][0]
        binding.option2Button.text = options[currentQuestionIndex][1]
        binding.option3Button.text = options[currentQuestionIndex][2]
        resetButtonColours()
        enableButtons()
    }

    private fun checkAnswer(selectedAnswerIndex: Int){
        val correctAnswerIndex = correctAnswers[currentQuestionIndex]

        if (selectedAnswerIndex == correctAnswerIndex){
            score++
            correctButtonColours(selectedAnswerIndex)
        } else {
            wrongButtonColours(selectedAnswerIndex)
            correctButtonColours(correctAnswerIndex)
        }
        disableButtons()
        if (currentQuestionIndex < questions.size -1){
            currentQuestionIndex++
            binding.questionText.postDelayed({displayQuestion()}, 1000)
        } else{
            showResults()
        }
    }

    private fun restartQuiz(){
        currentQuestionIndex = 0
        score = 0
        displayQuestion()
        binding.scoreText.text =""
        binding.restartButton.isEnabled = false
    }


}