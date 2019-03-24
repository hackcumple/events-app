<template>
    <div class="home" v-if="isLoading">
        <Loader/>
    </div>
    <div class="home" v-else>
        <AdminMenubar/>
        <div class="wrapper-normal">
            <div class="admin-img"></div>
            <h1>Panel administratora </h1>
            <div class="lecturer-section">
                <img class="avatar" src="./../assets/avatar.png" alt="Avatar">
                Oceny prelegentów.
                Zbiór ocen wszystkich preleganetów posortowanych rosnąco.
            </div>
            <div>
                <ul class="nearby-places-ul">
                    <li class="nearby-places-li" v-for="item in items">
                        <img class="speaker-logo-img" src="./../assets/avatar.png"  >
                        <div class="nearby-places-name">{{ item.Name }}</div>
                        <div class="speaker-rank-wrapper">
                            <div class="rank">
                                <font-awesome-icon  v-for="rate in item.Rate" icon="star" size="lg" class="checked"/><br />
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
    import Loader from "@/components/Loader.vue";
    import AdminMenubar from "../components/AdminMenubar";

    export default {
        name: "speakerevaluation",
        components: {
            Loader,
            AdminMenubar
        },
        data() {
            return {
                isLoading: true,
                items: [
                    {Name: "Adam Małysz", Rate:5},
                    {Name: "Mariusz Pudzianowski", Rate:5},
                    {Name: "Robert Mateja", Rate:4},
                    {Name: "Robert Kubica", Rate:3},
                    {Name: "Wojciech Szczęsny", Rate:3},
                    {Name: "Michał Wójcik", Rate:3},
                    {Name: "Magda Gessler", Rate:2},
                ]
            };
        },
        created() {
        },
        mounted() {
            this.isLoading = false;
        }
    }
</script>

