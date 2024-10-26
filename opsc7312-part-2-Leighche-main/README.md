![Beige Feminine Personal LinkedIn Banner](https://github.com/user-attachments/assets/da1eb80b-a653-4e4c-81a8-d38a9f1abd89)

# Still: A Meditation and Mindfulness App

**By InvestIQ**

## 🔵 Table of Contents
1. [Overview](#overview)
2. [Team Members](#team-members)
3. [Main Features](#main-features)
   - [Focus](#focus)
   - [Meditate](#meditate)
   - [Wind Down](#wind-down)
   - [Breathe](#breathe)
4. [Additional Features](#additional-features)
   - [Notepad](#notepad)
   - [Charging Animations - Lightbulb](#charging-animations---lightbulb)
   - [Mood Tracker](#mood-tracker)
   - [Arcade Space](#arcade-space)
   - [Chat with Serena](#chat-with-serena)
5. [Requirements](#requirements)
   - [Registration and Login](#registration-and-login)
   - [Biometric Authentication](#biometric-authentication)
   - [Settings Customization](#settings-customization)
   - [Rest API Integration](#rest-api-integration)
   - [Offline mode with sync](#offline-mode-with-sync)
   - [Real time notifications](#real-time-notifications)
   - [Multi-Language Support](#multi-language-support)
6. [SSO](#sso)
7. [In Depth Analyses of Serena-AI](#in-depth-analyses-of-serena-ai)
8. [Serenity API](#serenity-api)
9. [Installation](#installation)
10. [Screenshots](#screenshots)
11. [Demo Video](#demo-video)
12. [License](#license)
13. [Contact](#contact)
14. [References](#references)

## Overview

**Still** is a meditation and mindfulness app designed to help you find an idyllic space within yourself. The app offers a diverse range of guided meditations, soothing soundscapes, and mindfulness exercises tailored for both beginners and experienced practitioners. With a comforting, user-friendly interface, Still makes it easy to find your calm and peace.

Whether you're seeking to reduce stress, improve focus, or cultivate a deeper sense of inner peace, Still is your perfect companion on the journey to a calmer, more centered you.

*(Bell & Troy, 2024; Tartakovsky & Pedersen, 2022)*

---

## Team Members

- Leighché Jaikarran (Team Lead)
- Naiya Haribhai (NFR Developer)
- Tanya Christine Govender (Full-Stack developer)
- Vikhayle (Full-Stack developer)

---

## Main Features

### Focus
Immerse yourself in calming soundscapes to enhance your meditation experience.
*(Jackson, 2022; Labib, 2021; Tartakovsky et al., 2022)*

### Meditate
Access guided meditation sessions designed to suit various needs, from stress relief to deep relaxation.
*(Calm, 2024; Google Play Store, 2024)*

### Wind Down
Unwind at the end of the day with exercises and sounds specifically curated to help you relax and prepare for restful sleep.
*(Calm, 2024; Google Play Store, 2024)*

### Breathe
Follow guided breathing exercises that center your mind and body, promoting overall well-being.
*(Jackson, 2022; Labib, 2021; Tartakovsky et al., 2022)*

![image](https://github.com/user-attachments/assets/59f861dc-995d-40d2-9698-a2bb96e0b7c2)
---

## Additional Features

### Notepad
- Keep track of your thoughts and daily activities.
- Your notes are securely locked behind biometric authentication, ensuring privacy and peace of mind.
*(Bell et al., 2024; Calm, 2024)*

### Charging Animations - Lightbulb
- Watch a lightbulb "charge" as you progress on your mindfulness journey, symbolizing the renewal of your thinking.
*(Google Play Store, 2024; Jackson, 2022; Labib, 2021)*

### Mood Tracker
- Monitor your emotional state over time, helping you gain insights into your mental well-being.
*(Bell et al., 2024; Calm, 2024)*

### Arcade Space
Take a break and relax with mini-games designed to entertain and de-stress:

- **Memory Game**: Sharpen your mind with engaging memory challenges.
- **Trivia**: Test your knowledge and learn something new while having fun.

*(Google Play Store, 2024; Jackson, 2022; Labib, 2021)*

### Chat with Serena
- Engage with **Serina**, our empathetic AI companion, who will guide you through your emotions and provide support on your emotional journey.
*(Tartakovsky et al., 2022; Tartakovsky, 2022)*

---

## Requirements

### Registration and Login
- Users must be able to register and log in using Single Sign-On (SSO).
- If users don't have an account, they will be prompted to create one.
*(Tartakovsky et al., 2022; Tartakovsky, 2022)*

### Biometric Authentication
- Implement fingerprint or facial recognition for secure user authentication.
*(Calm, 2024; Google Play Store, 2024; Jackson, 2022)*

### Settings Customization
- Users must be able to change their settings in the app.
*(Labib, 2021)*

### REST API Integration
- Connect the app to a custom REST API that communicates with a database.

- Link to the API: https://still-2004.uc.r.appspot.com

- The API has 4 Main enpoints:

  1. https://still-2004.uc.r.appspot.com/WindDownSongs
 
  2. https://still-2004.uc.r.appspot.com/BreatheSongs
 
  3. https://still-2004.uc.r.appspot.com/MeditateSongs
 
  4. https://still-2004.uc.r.appspot.com/FocusSongs
    
*(Calm, 2024; Google Play Store, 2024; Jackson, 2022; Labib, 2021; Tartakovsky et al., 2022)*

### Offline Mode with Sync
- Allow users to perform certain actions offline with data syncing when reconnected.
- Use **RoomDB** or **SQLite** for offline storage.
*(Bell et al., 2024; Calm, 2024; Google Play Store, 2024; Jackson, 2022; Labib, 2021; Tartakovsky et al., 2022)*

### Real-time Notifications
- Implement a push notification system for real-time updates and alerts.
*(Tartakovsky et al., 2022; Tartakovsky, 2022)*

### Multi-language Support
- Support at least 2 South African languages in addition to English.
*(Bell et al., 2024; Calm, 2024)*

<img src="https://github.com/user-attachments/assets/03e57abe-fbce-407c-bb0d-857729814442" width="300px" />

---

## SSO
- Users must be able to register and log in using Single Sign-On (SSO).
- The STILL Application makes use of Google Authentication and single sign on:
    It can be seen below that an account was added to firebase using google single sign on
![Screenshot 2024-09-30 at 23 05 55](https://github.com/user-attachments/assets/6f7defd8-2a2d-48d1-bc32-35cada359a64)
*(Tartakovsky et al., 2022; Tartakovsky, 2022)*

--- 
## In Depth Analyses of Serena-AI

Integrating Gemini AI as an Emotional Assistant

- In our Still app, we integrated Gemini AI to function as a personalized emotional assistant. This AI-powered companion, named Serina, helps users manage their emotions and provides personalized guidance on their mindfulness journey. Here's how Gemini AI enhances the app's capabilities:

- Emotion Detection: Using advanced natural language processing (NLP) and sentiment analysis, Gemini AI interacts with users and interprets their emotional states based on the responses provided during conversations.

- Personalized Assistance: Once the emotional state is detected, Gemini AI customizes its responses to offer support. For instance, if a user feels anxious, Serina suggests calming exercises, soundscapes, or guided meditations tailored to relieve stress.

- Continuous Learning: Gemini AI continuously improves its interaction with the user by learning from previous emotional inputs. This makes it better suited to offer personalized recommendations over time.

- Real-Time Interaction: Users can engage with Serina in real time, receiving instant feedback and emotional support. This makes the interaction feel empathetic and human-like, enhancing the user's emotional well-being.

- Mindfulness Guidance: Beyond basic emotional support, Gemini AI serves as a guide through the mindfulness exercises within the app. Based on user moods and preferences, Serina suggests suitable meditation sessions, breathing exercises, or soothing soundscapes.

This integration makes Still unique, providing users with a constant emotional companion that adapts to their mental state, offering meaningful suggestions for maintaining balance and calm.

---

## Serenity API

In the Still app, we use an API to fetch calming songs and soundscapes that enhance the user's meditation and mindfulness experience. Here’s how it works:

**How the Song API Integration Works**

- API Request: The app sends a request to an external music API that provides access to a collection of songs designed for relaxation, mindfulness, and meditation. This request is made through HTTP protocols using GET requests, asking for specific types of music based on user preferences or emotional states detected by Gemini AI.
  
- Data Filtering: The API allows us to filter songs based on different criteria, such as:

- Mood-based categories: Relaxing, stress-relief, focus-enhancing, etc.
- Song genre: Nature sounds, instrumental, ambient, etc.
- Duration: Short tracks for quick meditations or longer ones for deep relaxation. These filters allow us to serve relevant songs that match the user’s current mood or meditation session.
- Fetching Songs: Once the request is made, the API responds with song data, including:
- Track URL: The direct link to stream or download the song.
- Metadata: Information like song title, artist, genre, and duration.
- Audio Formats: Depending on the API, it may provide the song in different formats (e.g., MP3, WAV).


## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/InvestIQ/still.git
   ```
  
2. Install dependencies:
   ```
   npm install
   ```
3. Start the application:
   ```
   npm start
   ```

---

## Screenshots
<table>
  <tr>
    <td>
      <img src="https://github.com/user-attachments/assets/e9fbbf61-b54e-4d8f-aaf3-3857bd2b697b" width="200" />
      <p>This is the sign up page, here the user can create an account or sign in with Google SSO. </p>
    </td>
    <td>
      <img src="https://github.com/user-attachments/assets/a92b84d4-f755-4b1d-8b8a-997da2d12744" width="200" />
      <p>This is the home page of the app, allowing the user to choose any of the features that the app has.</p>
    </td>
  </tr>
  <tr>
    <td>
      <img src="https://github.com/user-attachments/assets/2a399a18-2cd1-425e-8481-f5af7cf50a5c" width="200" />
      <p>This page displays all the music in a certain category, the user can click on one of the songs to listen to it.</p>
    </td>
    <td>
      <img src="https://github.com/user-attachments/assets/8d70ff86-a65d-494a-ba2e-c40f28ba85a8" width="200" />
      <p>This is the screen that the user will see when they play music.</p>
    </td>
  </tr>
  <tr>
    <td>
      <img src="https://github.com/user-attachments/assets/f30750aa-2a1e-4e6c-a5a7-a6b8b1e0e4c6" width="200" />
      <p>This screen displays one of the quiz game questions.</p>
    </td>
    <td>
      <img src="https://github.com/user-attachments/assets/17977ef6-f8f6-418d-afae-5d2a54a1e198" width="200" />
      <p>This screen displays the memory game.</p>
    </td>
  </tr>
  <tr>
    <td>
      <img src="https://github.com/user-attachments/assets/8b66dfad-b744-4cf1-9b45-9b800ffe2e7a" width="200" />
      <p>This is the settings page of the app, the user can edit their email address, their password and delete their account.</p>
    </td>
    <td>
      <img src="https://github.com/user-attachments/assets/d76d5be2-f6a8-4eb0-a74f-b18c4e42bc13" width="200" />
      <p>This is the login page of the app, the user can log in with their email address or with Google SSO.</p>
    </td>
  </tr>
  <tr>
    <td>
      <img src="https://github.com/user-attachments/assets/748c0009-411e-4d8a-ab66-23e68a785fff" width="200" />
      <p>This is the mind hub, it allows for the user to interact with Serea-AI, the vibe check and powering up.</p>
    </td>
    <td>
      <img src="https://github.com/user-attachments/assets/309e5f4a-4f37-4e5e-b569-f4c0a84e1cd1" width="200" />
      <p>This screen allows the user to interact with Serena-AI.</p>
    </td>
  </tr>
</table>

---

## Demo Video
Watch our demo video to see Still in action:

<img src ="recording copy.gif"  />


<div align="left">
  <img src="https://media3.giphy.com/media/rrOif8vmuM6g05Zha5/giphy.gif?cid=6c09b9525yudzzl1gio0aotte4jpryu1uy7dlflc01rk9s3i&ep=v1_internal_gif_by_id&rid=giphy.gif&ct=s" alt="Cloud Image" width="300">
</div>


<a href="https://youtu.be/8q-LnL8vNBw" target="_blank">
  <img src="https://img.shields.io/badge/YouTube-FF0000?style=for-the-badge&logo=youtube&logoColor=white" alt="YouTube Icon">
</a>
<p>

--- 
## License

This project is licensed under the MIT License - see the LICENSE.md file for details.

--- 

## Contact

For any inquiries or support, please contact us at support@investiq.com.

<img src="https://github.com/user-attachments/assets/ca178955-f264-4396-8b4f-4397c2fe3dde" width="300px" />


---

## References
Bell, C., Troy, B. 2024. Headspace App Review 2024: Pros & Cons, Cost & Who It’s Right For, 30 April 2024. [Online]. Available at: 
https://www.choosingtherapy.com/headspace-review/#:~:text=Pros%20%26%20Cons%20of%20Headspace&text=The%20app%20presents%20mindfulness%20and,off%20with%20other%20meditation%20apps. [Accessed 5  August 2024]. 

Calm. 2024. Calm for Kids, 2024. [Online]. Available at: https://www.calm.com/app/kids [Accessed 7 August 2024].

Combs, M. 2021. This Timer App Is the Answer to Your Focus Woes, 12 August 2021. [Online]. Available at: https://www.cnet.com/tech/services-and-software/this-timer-app-is-the-answer-to-your-focus-woes/  [Accessed 10 August 2024]. 

Dalai Lama. 1998. The Art of Happiness Synopsis, October 26, 1998. [Online]. Available at:  https://www.goodreads.com/book/show/38210.The_Art_of_Happiness [Accessed 15 August 2024].

Frania, N. 2024. How to Use Check-Ins, 19 April 2024. [Online]. Available at: https://support.calm.com/hc/en-us/articles/9699990936731-How-to-Use-Check-Ins [Accessed 19 August 2024]. 

Google Play Store, 2024. Calm App, 2024. [Online]. Available at: https://play.google.com/store/apps/details?id=com.calm.android&pli=1 [Accessed 7 August 2024].
Grennan, M. 2024. Calm Journals, April 2024. [Online]. Available at: https://support.calm.com/hc/en-us/articles/360002773093-Calm-Journals [Accessed 19 August 2024]. 
Jackson, S. 2022. I tried two of the most popular meditation apps, Headspace and Calm, 22 December 2022. [Online]. Available at: https://www.businessinsider.com/meditation-apps-review-headspace-calm-one-was-way-better-2021-9#overall-calm-was-the-clear-winner-for-me-32 [Accessed 19 August].
Kwai, I. 2023. Jimmy Stewart AI Sleep Story,  5 December 2023. [Online]. Available at:  https://www.nytimes.com/2023/12/05/technology/calm-jimmy-stewart-ai.html [Accessed 7 August 2024].

Google. 2024. Gemini - Google DeepMind. [Online]. Available at: https://deepmind.google/technologies/gemini/ [Accessed 19 August 2024].

Labib, M.K. 2021. Forest app review : Most useful App to get things done, 20 July 2021. [Online]. Available at: https://moinulkarim.com/forest-app-review/  [Accessed 7 August 2024]. 

Medium. 2020. Forest App is Good, But is it Good Enough for You? 3 Alternative Focus Apps, 9 August 2020. [Online]. Available at: https://medium.com/@AppGrooves/forest-app-is-good-but-is-it-good-enough-for-you-3-alternative-focus-apps-1d63ed7eb79a  [Accessed 5 August 2024]. 

Nagar, T. 2023. How to build an app like calm, 13 June 2023. [Online]. Available at:  https://devtechnosys.com/insights/how-to-build-an-app-like-calm/ [Accessed 15 August 2024].

Neumann, K. 2024. Calm App Review, 4 July 2024. [Online]. Available at: https://www.forbes.com/health/mind/calm-app-review/ [Accessed 6 August 2024].

OpenAI. 2024. API Deployment Request, 28 September 2024.[Online]. Available at: https://chatgpt.com/c/66f2f102-6100-8013-a142-3f4b7b66d7b5 [Accessed 28 September 2024].

OpenAI. 2024. JSON Object, 29 September 2024.[Online]. Available at: https://chatgpt.com/share/66fa87e1-c77c-8005-b50d-c2c441854ab0 [Accessed 29 September 2024].

Pichai, S. 2023. Introducing Gemini: our largest and most capable AI model, 06 December 2023. [Online]. Available at: https://blog.google/technology/ai/google-gemini-ai/ [Accessed 19 August 2024]. 
 
Tartakovsky, M. 2022. 2022 Headspace Review: App Pros and Cons, 3 May 2022. [Online]. Available at: https://psychcentral.com/reviews/headspace-app-reviews [Accessed 19 August 2024].

Tartakovsky, M., Pedersen, T. 2022. Headspace vs. Calm: Which App Is Right for You?, 9 May 2022. [Online]. Available at: https://psychcentral.com/reviews/headspace-vs-calm [Accessed 19 August 2024].
