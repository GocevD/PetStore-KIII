import React, { useEffect, useState } from 'react'
import ReactDOM from 'react-dom/client'

function App() {
  const [pets, setPets] = useState([])
  const [users, setUsers] = useState([])
  const [history, setHistory] = useState([])
  const [error, setError] = useState("")
  
  // Fetch pets
  const fetchPets = () => {
    fetch('/api/list-pets')
      .then(res => res.json())
      .then(data => setPets(data))
      .catch(() => setPets([]))
  }
  // Fetch users
  const fetchUsers = () => {
    fetch('/api/list-users')
      .then(res => res.json())
      .then(data => setUsers(data))
      .catch(() => setUsers([]))
  }
  // Fetch history
  const fetchHistory = () => {
    fetch('/api/history')
      .then(res => res.json())
      .then(data => setHistory(data))
      .catch(() => setHistory([]))
  }

  useEffect(() => {
    fetchPets()
    fetchUsers()
    fetchHistory()
  }, [])

  // Actions
  const createPets = () => {
    fetch('/api/create-pets', { method: 'POST' })
      .then(() => fetchPets())
      .catch(() => setError("Failed to create pets"))
  }
  const createUsers = () => {
    fetch('/api/create-users', { method: 'POST' })
      .then(() => fetchUsers())
      .catch(() => setError("Failed to create users"))
  }
  const buy = () => {
    fetch('/api/buy', { method: 'POST' })
      .then(() => fetchHistory())
      .catch(() => setError("Failed to buy"))
  }

  return (
    <div style={{ maxWidth: 600, margin: '2rem auto', fontFamily: 'sans-serif' }}>
      <h1>PetStore Frontend</h1>
      {error && <div style={{color:'red'}}>{error}</div>}
      <section>
        <h2>Pets</h2>
        <button onClick={createPets}>Create Pets</button>
        <ul>
          {pets.length === 0 && <li>No pets found or backend not reachable.</li>}
          {pets.map(pet => (
            <li key={pet.id}>{pet.name} ({pet.type})</li>
          ))}
        </ul>
      </section>
      <section>
        <h2>Users</h2>
        <button onClick={createUsers}>Create Users</button>
        <ul>
          {users.length === 0 && <li>No users found or backend not reachable.</li>}
          {users.map(user => (
            <li key={user.id}>{user.firstName} {user.lastName}</li>
          ))}
        </ul>
      </section>
      <section>
        <h2>History Log</h2>
        <button onClick={buy}>Buy</button>
        <ul>
          {history.length === 0 && <li>No history found or backend not reachable.</li>}
          {history.map((log, idx) => (
            <li key={idx}>
              {log.dateOfExecution ? new Date(log.dateOfExecution).toLocaleString() : 'No date'}: 
              {log.successfulPurchases} successful, {log.failedPurchases} failed
            </li>
          ))}
        </ul>
      </section>
    </div>
  )
}

ReactDOM.createRoot(document.getElementById('root')).render(<App />) 