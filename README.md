# 🎮 Poker Game

## 📖 Description

This project implements an object-oriented poker game simulation. The player interacts with a virtual poker machine, placing bets, receiving cards, and making strategic decisions in pursuit of increasing their bankroll.

## 🕹️ Gameplay Overview

- The player starts by depositing coins into the game. This amount is referred to as the **bankroll**.
- To play a round, the player places a **bet of 1 to 5 coins**, not exceeding their current bankroll.
- A hand of **five cards** is dealt from a standard **52-card deck**. The deck is reshuffled before each round.
- The player chooses which cards to **hold** and which to **discard**.
- New cards are dealt to replace the discarded ones.
- The final hand is **scored**:
  - If it's a **winning hand**, the player receives a payout based on the hand's rank.
  - If it's **not a winning hand**, the bet amount is lost.

## 💰 Bankroll Management

- The player can **add coins** to the bankroll before any game round.
- The game continues as long as the bankroll is not depleted.
- The player can choose to **cash out and quit** at any time.

## 🚀 Features

- Object-oriented design
- Full 52-card deck simulation
- Re-shuffled deck per game
- Scoring based on standard poker hand rankings
- Dynamic bankroll adjustment
- Interactive decision-making (hold/discard)


