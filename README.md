# Mobile-App
This project is a basic clone of WhatsApp, called "Chatter," built using Jetpack Compose. The app currently implements the core functionality for text messaging. You can send and view messages, with a UI that mimics the look and feel of WhatsApp's chat interface and UI

## Features
* Chat Screen: You can send and receive text messages using a familiar chat interface.
* Sample Chat Data: The app demonstrates chat functionality with hardcoded sample data (e.g., name, message text, and timestamp).
* Text Input Area: A custom-designed bottom bar to type messages, with a floating action button for sending messages.
* Message Bubbles: Messages are displayed in alternating left-right alignment, similar to WhatsApp's chat design.

## File Overview
 * MainActivity.kt: Handles the user interface for the chat screen. It displays the list of chat messages and allows the user to input and send text messages.
 * StatusScreen.kt: Currently a placeholder screen for status updates. this will allow users to post and view text, images, and videos as statuses.
 * CallsScreen.kt: Manages the display of call logs. This screen shows a list of sample calls, including incoming, outgoing, and missed calls with timestamps. It is fully implemented for displaying sample data.
 * WhatsAppChatList.kt: Defines how individual chat messages are displayed. It handles the layout and appearance of each message, adjusting based on whether the message is incoming or outgoing.
 * SampleData.kt: Contains the data model for each chat message. It stores the message content, sender name, timestamp, and placeholder for media URLs. This sample data is used to populate the chat UI.
 * WhatsAppChatViewModel.kt: Contains the ViewModel for managing chat data. It holds the list of messages and provides methods for adding new messages. It communicates with the UI to update the chat when new data is added.
 * Color.kt: Contains color values used across the app. It defines the app’s color scheme, ensuring consistent styling throughout the UI.
