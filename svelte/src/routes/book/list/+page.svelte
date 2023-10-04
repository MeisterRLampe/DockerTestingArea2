<script>

    export let data;


    let idbooks = '';
    let booktitle ='';
    let pages = '';
    let price = "";


    const handleDeleteById = async () => {
       const idData = {

          idbooks,
          booktitle,
          pages,
          price
       };
       const response = await fetch(`http://localhost:8080/api/book/delete/${idData.idbooks}`, {
          method: "DELETE",
          headers: {
             "Content-Type": "application/json"
          },

       });
       if (response.ok) {
          // Erfolgreich erstellt
          console.log("Buch wurde erfolgreich gelöscht");
       } else {
          // Fehler beim Erstellen
          console.error('Fehler beim löschen');
       }
    }


</script>


<main>
   <div class="relative overflow-x-auto max-h-80 shadow-md sm:rounded-lg">
      <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
         <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
         <tr>
            <th scope="col" class="px-6 py-3">
               ID
            </th>
            <th scope="col" class="px-6 py-3">
               Title
            </th>
            <th scope="col" class="px-6 py-3">
               Pages
            </th>
            <th scope="col" class="px-6 py-3">
               Price
            </th>
         </tr>
         </thead>
         <tbody>
         {#each data.item as book}
            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
               <td class="px-6 py-4">
                  {book.idbooks}
               </td>
               <td class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                  {book.booktitle}
               </td>
               <td class="px-6 py-4">
                  {book.pages}
               </td>
               <td class="px-6 py-4">
                  {book.price}
               </td>
            </tr>
         {/each}
         </tbody>
      </table>
   </div>

      <div class="centered">
         <form on:submit={handleDeleteById}>
            <input  placeholder="Delete By Id" class="rounded mt-4" type="text" width="250px" height="10px">
            <div class="mt-4">
               <button type="submit" class="btn btn-success sm:badge-ghost">Delete</button>
            </div>
         </form>
      </div>
   </main>

   <style lang="postcss">
      .centered {
         margin: auto;
         width: 15%;
         margin-top: 20px;
      }
      /*Maximale Höhe*/
      .max-h-80 {
         max-height: 80vh;
         overflow-y: auto;
      }
   </style>


