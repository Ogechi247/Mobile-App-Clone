# Mobile-App
This project is a basic clone of WhatsApp, called "Chatter," built using Jetpack Compose. The app currently implements the core functionality for text messaging. You can send and view messages, with a UI that mimics the look and feel of WhatsApp's chat interface and UI

## Features
* Chat Screen: You can send and receive text messages using a familiar chat interface.
* Sample Chat Data: The app demonstrates chat functionality with hardcoded sample data (e.g., name, message text, and timestamp).
* Text Input Area: A custom-designed bottom bar to type messages, with a floating action button for sending messages.
* Message Bubbles: Messages are displayed in alternating left-right alignment, similar to WhatsApp's chat design.

  ## File Overview
  ###  MainActivity.kt
This file serves as the entry point of the app and is responsible for setting up the navigation between different screens.
* NavController Setup: Manages navigation between screens like ChatScreen, CallsScreen, and StatusScreen.
* App Theme: Initializes the app's visual theme, such as the primary color scheme and overall look.

### ChatScreen.kt
This file contains the main UI for the chat functionality. It includes the BottomDesign composable for sending messages and the ChatListItem composable for displaying messages.
* BottomDesign Composable: A bottom row with a text field, emoji, attach, and camera icons. Users can type and send text messages.
* Text Field: Lets users type messages with an optional placeholder text. The keyboard type is set to "Text," and it supports multi-line input.
* Send Button: A floating action button at the bottom-right that sends the typed message when clicked.
