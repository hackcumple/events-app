<template>
    <div class="home" v-if="isLoading">
        <Loader/>
    </div>
    <div class="home" v-else>
        <Menubar/>
        <div class="wrapper-normal">
            <h1>{{ name }}</h1>
            <h2 class="where">Katowice, Galeria Rondo Sztuki, Rondo im. Jerzego Ziętka 2</h2>
            <div class="img-cnt">
                <img src="../assets/map.png">
            </div>
            <h2 class="where">W pobliżu</h2>

            <div>
                <ul class="nearby-places-ul">
                    <li class="nearby-places-li" v-for="item in items">
                        <img class="nearby-places-img" :src= 'require("../static/" + item.Image)'  >
                        <div class="nearby-places-name">{{ item.Name }}</div>
                        <div>{{ item.Type }}</div>
                        <div>
                            {{ item.Address }}
                            {{ item.Distance }}
                        </div>
                    </li>
                </ul>
            </div>


        </div>
    </div>
</template>

<script>
    import Loader from "@/components/Loader.vue";
    import Menubar from "@/components/Menubar.vue";

    export default {
        name: "directions",
        components: {
            Loader,
            Menubar
        },
        data() {
            return {
                isLoading: true,
                items: [
                    {Name: 'Via Toscana', Type: 'Kuchnia śródziemnomorska', Distance: '300m', Address: 'Uniwersytecka 13', Image:"place1.jpg"},
                    {Name: 'Złoty Osioł', Type: 'Kuchnia wegetariańska', Distance: '300m', Address: 'Mariacka 1', Image:"place2.jpg"},
                    {Name: 'Tatiana', Type: 'Restauracja', Distance: '650m', Address: 'Staromiejska 5',Image:"place3.jpg"},
                    {Name: 'Kyoto Sushi', Type: 'Kuchnia japońska', Distance: '350m', Address: 'Uniwersytecka 13',Image:"place4.jpg"}
                ],
                ...this.$store.state.eventData
            };
        },
        methods: {
            justDoSomething() {
                console.log("Witam eX");
            },
        },
        created() {
        },
        mounted() {
            this.isLoading = false;
        }
    };


</script>
