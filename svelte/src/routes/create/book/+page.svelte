<script>

    import {onMount} from "svelte";

         let isOpen = false;
        let selectedCategory = null;

        let booktitle = '';
        let pages = '';
        let price = '';
        let releaseDate = '';
        let bookEntry = '';
        let categoryname = '';

        let data = {
            categories: [],
        };

        async function fetchCategories() {
            try {
                const response = await fetch('http://localhost:8080/api/book/category');
                if (response.ok) {
                    data.categories = await response.json();
                } else {
                    console.error("Fehler beim Abrufen der Kategorien")
                }
            } catch (error) {
                console.error("Fehler beim Abrufen der Kategorien", error)
            }
        }
        onMount(fetchCategories)
    function toggleDropdown() {
        isOpen = !isOpen;
    }

    function selectCategory(category) {
        selectedCategory = category;
        isOpen = false; // Dropdown schließen, nachdem eine Kategorie ausgewählt wurde
    }

    function saveCategory() {
        // Hier können Sie die ausgewählte Kategorie speichern
        if (selectedCategory) {
            // Beispiel: Kategorie in einer Variable speichern
            const selectedCategoryId = selectedCategory.id;
            // Senden Sie die selectedCategoryId an Ihren Server oder speichern Sie sie in der gewünschten Form
            console.log('Ausgewählte Kategorie-ID:', selectedCategoryId);
        }
    }


        // Rufen Sie die Kategorien ab, wenn die Komponente geladen wird
        fetchCategories();

        async function handler() {
            const formData = {
                booktitle,
                pages,
                price,
                categoryname,
                releaseDate,
                bookEntry
            };
            const response = await fetch('http://localhost:8080/api/book/create', {
                method: 'POST',
                headers: {
                    "Content-Type": 'application/json'
                },
                body: JSON.stringify(formData)
            });
            if (response.ok) {
                // Erfolgreich erstellt
                console.log('Buch wurde erstellt');
            } else {
                // Fehler beim Erstellen
                console.error('Fehler beim Erstellen');
            }
        }

</script>


<main>
    <form on:submit={handler}>
        <div class="flex">
            <div class="container text-black -mb-20 flex-col flex-1 w-64">
                <label>Title:</label>
                <div>
                    <input bind:value={booktitle} type="text" class="input input-bordered w-full max-w-xs bg-blue-200"/>
                </div>
                <label>Pages:</label>
                <div>
                    <input bind:value={pages} name="pages" type="text"
                           class="input input-bordered w-full max-w-xs bg-blue-200"/>
                </div>
                <label>Price:</label>
                <div>
                    <input bind:value={price} name="price" type="text"
                           class="input input-bordered w-full max-w-xs bg-blue-200"/>
                </div>
                <label>Release:</label>
                <div>
                    <input bind:value={releaseDate} name="releaseDate" type="date"
                           class="input input-bordered w-full max-w-xs bg-blue-200"/>
                </div>
                <div class="dropdown">
                    <button class="btn btn-secondary" on:click={toggleDropdown}>
                        {#if selectedCategory}
                        {selectedCategory.categoryname}

                        {:else}
                        Wähle Kategorie
                        {/if}
                    </button>


                    {#if isOpen}
                        {#each data.categories as category (category.id) }
                          <div
                            class="dropdown-item"
                            on:click={() => selectCategory(category)}
                            role="menuitem"
                            tabindex="0"
                            on:keydown={(e) => handleMenuKeyDown(e, category)}
                            > {category.categoryname}
                            </div>
                        {/each}
                    {/if}
                </div>


                <div class="flex 1 w-64 mr-40 mt-20">
                    <div>
                        <textarea bind:value={bookEntry} class="justify textarea textarea-bordered bg-blue-200"
                                  name="bookEntry" rows="10" cols="50"></textarea>
                    </div>
                </div>
            </div>

        <div class="container grid grid-cols-5 gap-3.5">
            <div>
                <button class="btn btn-success" type="submit">Create a Book</button>
            </div>
            <div>
                <button class="btn btn-error" type="reset">Reset</button>
            <div>
                <input bind:value={bookEntry} type="file" class="file-input file-input-bordered w-full max-w-xs"/>
            </div>
            </div>
            <div></div>
        </div>
        </div>
    </form>
</main>
<style>

    /* Stil für das Dropdown-Menü */
    .dropdown {
        position: relative;
        display: inline-block;
    }

    .dropdown .dropdown-menu {
        display: none;
        position: absolute;
        background-color: #fff;
        min-width: 160px;
        border: 1px solid #ccc;
        box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
        z-index: 1;
    }

    .dropdown.show .dropdown-menu {
        display: block;
    }

    /* Stil für Dropdown-Elemente */
    .dropdown-item {
        padding: 10px;
        text-decoration: none;
        display: block;
        color: #333;
    }

    .dropdown-item:hover {
        background-color: #f2f2f2;
    }


    textarea {
        resize: none;
    }
</style>

