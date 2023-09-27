<script>
    let name = '';
    let address = '';

    const handleSubmit = async () => {
        const data = {
            name,
            address
        };

        const response = await fetch('http://localhost:8080/api/customer/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            // Erfolgreich erstellt
            console.log('Kunde erfolgreich erstellt');
        } else {
            // Fehler beim Erstellen
            console.error('Fehler beim Erstellen des Kunden');
        }
    };

</script>

<main>
    <form on:submit={handleSubmit}>
        <div class="container ml-80 mt-60">
        <div>
            <label>Name:</label>
            <input class="ml-4 bg-blue-200"  type="text" bind:value={name}>
            </div>

            <div><label>Adresse:</label>
            <input class="mt-4 bg-blue-200 " type="text" bind:value={address}>
            </div>
            <div>
            <button class="btn  ml-24 mt-4 w-20" type="submit">Click</button>
            </div>
            </div>
    </form>
</main>


<style>

    .centered{
        margin: auto;
        width: 50%;
    }

    label{
        color: black;
    }

    input{

        border-radius: 15px;

    }
</style>


