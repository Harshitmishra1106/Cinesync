# 🎬 Cinesync – Movies & TV Shows Explorer

A modern **Jetpack Compose** Android app that lets users explore movies and TV shows from the **Watchmode API**.  
The app showcases clean architecture, reactive programming using **RxKotlin**, and smooth navigation — all while providing a polished and interactive user experience.

---

## 🎥 App Demo

<p align="center">
  <img src="Cinesync_demo.gif" alt="App Demo" width="350"/>
</p>

---

## 🚀 Features Implemented

- 🎞️ **Dynamic Toggle** between Movies 🎥 and TV Shows 📺 using separate API calls simultaneously
- 🔄 **Simultaneous data fetching** via `Single.zip()` (RxKotlin) for performance and responsiveness  
- 🪄 **Shimmer loading effect** to enhance UX while waiting for network data  
- 📱 **Responsive grid layout** for adaptive UI across screen sizes  
- 🧩 **Details Screen** displaying details of the selected movie with a clean layout  
- 🧪 **Unit Testing** for verifying API data parsing and model behavior  

---

## 💡 Tech Stack

- **Language:** Kotlin  
- **Architecture:** MVVM + RxKotlin
- **UI:** Jetpack Compose  
- **Networking:** Retrofit + Gson 
- **Async Operations:** RxKotlin + Single.zip()  
- **Testing:** JUnit  

---

## 🧠 My Experience

- Developing *Cinesync* was an incredible learning journey.  
- At first, setting up parallel API calls for both Movies and TV Shows using RxKotlin’s `Single.zip()` felt challenging — but it helped me understand reactive programming at a deeper level.  
- While implementing **shimmer effects**, I realized how smooth animations can improve perceived performance.  
- The project also strengthened my grasp of **Compose layouts**, especially balancing card design aesthetics within a grid.  
- Debugging network issues and designing an elegant, scrollable details layout gave me practical insight into building user-centered Android applications.

---

## 🧩 Challenges Faced

- Handling multiple API endpoints and data filtering (especially for TV vs Movie separation)  
- Managing async operations while ensuring UI consistency 
- Optimizing image loading performance and avoiding flicker 
- Finding correct endpoints to get desired data from Watchmode API

---

## 🎯 What I Learned

- Efficient data handling using **RxKotlin’s reactive streams**  
- Designing visually appealing and accessible UIs in **Jetpack Compose**  
- Importance of shimmer placeholders to keep users engaged during load times  
- Structured project modularization and proper API layer abstraction  
- Writing meaningful unit tests to verify app logic  

## 📦 Download & Demo

🎥 **Video Explanation:**  
Watch the walkthrough of the app’s features and design decisions here:  
👉 [Here's the code walkthrough](https://drive.google.com/file/d/1EruVpuabov_wy1rm22Wyi7RuzN7NKsKH/view?usp=sharing)

📱 **Download APK:**  
Try the app on your Android device by downloading the latest release:  
👉 [Download APK from Google Drive](https://drive.google.com/file/d/1vXtNwoKlfGdGl5STMU5rNBvKD-VET1O-/view?usp=sharing)
