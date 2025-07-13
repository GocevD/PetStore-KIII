import React, { useEffect, useState } from 'react'
import ReactDOM from 'react-dom/client'

function App() {
  const [pets, setPets] = useState([])

  useEffect(() => {
    fetch('/api/pets')
      .then(res => res.json())
      .then(data => setPets(data))
      .catch(() => setPets([]))
  }, [])

  return (
    <div>
      <h1>PetStore Frontend</h1>
      <p>Welcome to the PetStore!</p>
      <h2>Pets:</h2>
      <ul>
        {pets.length === 0 && <li>No pets found or backend not reachable.</li>}
        {pets.map(pet => (
          <li key={pet.id}>{pet.name} ({pet.type})</li>
        ))}
      </ul>
    </div>
  )
}

ReactDOM.createRoot(document.getElementById('root')).render(<App />) 