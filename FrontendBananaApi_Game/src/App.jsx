import React, { useState } from 'react';
import './App.css'; // we'll create this next

function App() {
  const [username, setUsername] = useState('');
  const [image, setImage] = useState('');
  const [guess, setGuess] = useState('');
  const [result, setResult] = useState('');
  const [roundId, setRoundId] = useState('');

  const startGame = async () => {
    if (!username) return alert('Enter username');

    const res = await fetch(`http://localhost:8080/api/game/start/${username}`);
    const data = await res.json();

    setImage(data.imageUrl);
    setRoundId(data.id);
    setResult('');
    setGuess('');
  };

  const submitGuess = async () => {
    if (!guess) return alert('Enter your guess');

    const params = new URLSearchParams({ username, roundId, guess });
    const res = await fetch(`http://localhost:8080/api/game/guess?${params.toString()}`, {
      method: 'POST',
    });
    const data = await res.json();
    setResult(`You scored ${data.roundScore} points!`);
    startGame(); // load next puzzle
  };

  return (
    <div className="container">
      <h1 className="title">🍌 Banana Puzzle Game</h1>

      <div className="input-group">
        <input
          type="text"
          placeholder="Enter username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          className="input-field"
        />
        <button className="btn" onClick={startGame}>Start Game</button>
      </div>

      {image && (
        <div className="game-section">
          <img src={image} alt="Banana Puzzle" className="puzzle-img" />
          <div className="guess-section">
            <input
              placeholder="Your guess"
              value={guess}
              onChange={(e) => setGuess(e.target.value)}
              className="input-field"
            />
            <button className="btn" onClick={submitGuess}>Submit Guess</button>
            <p className="result-text">{result}</p>
          </div>
        </div>
      )}
    </div>
  );
}

export default App;
