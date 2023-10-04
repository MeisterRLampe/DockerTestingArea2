<script>
    export let data;
</script>

<main>
    <div class="relative overflow-x-auto max-h-80 shadow-md sm:rounded-lg">
        <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
            <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
                <th scope="col" class="px-6 py-3">
                    Name:
                </th>
                <th scope="col" class="px-6 py-3">
                    Adresse:
                </th>
                <th scope="col" class="px-6 py-3">
                    Zip:
                </th>
                <th scope="col" class="px-6 py-3">
                    Email:
                </th>
            </tr>
            </thead>
            <tbody>
            {#each data.item as user}
                <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
                    <td class="px-6 py-4">
                        {user.name}
                    </td>
                    <td class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        {user.address}
                    </td>
                    <td class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        {user.zipcode}
                    </td>
                    <td class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        {user.email}
                    </td>


                </tr>
            {/each}
            </tbody>
        </table>
    </div>
</main>