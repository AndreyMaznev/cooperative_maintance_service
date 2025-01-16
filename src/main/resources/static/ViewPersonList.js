import React, { useEffect, useState } from 'react';
import axios from 'axios';




function App() {
    const [persons, setPersons] = useState([]);

    useEffect(() => {
        axios.get('/api/v1/person/all')
            .then(response => setPersons(response.data))
            .catch(error => console.error('Error fetching data:', error));
    }, []);

    return (
        <div>
            <h1>Person List</h1>
            <ul>
                {persons.map(person => (
                    <li key={person.id}>{person.username}</li>
                ))}
            </ul>
        </div>
    );
}

export default App;