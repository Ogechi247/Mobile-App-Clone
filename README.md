# Mobile-App
This project is a basic clone of WhatsApp, called "Chatter," built using Jetpack Compose. The app currently implements the core functionality for text messaging. You can send and view messages, with a UI that mimics the look and feel of WhatsApp's chat interface and UI

## Features
* Chat Screen: You can send and receive text messages using a familiar chat interface.
* Sample Chat Data: The app demonstrates chat functionality with hardcoded sample data (e.g., name, message text, and timestamp).
* Text Input Area: A custom-designed bottom bar to type messages, with a floating action button for sending messages.
* Message Bubbles: Messages are displayed in alternating left-right alignment, similar to WhatsApp's chat design.

## File Overview
MainActivity.kt
    * Purpose: Manages the UI for displaying the chat screen.
    * Details: It shows the list of messages using LazyColumn and allows users to type 
    messages in a TextField. The UI supports sending text messages and uses SampleData
    to store chat entries. It currently only supports sending text messages, with
    functionality for attaching files and images pending.
