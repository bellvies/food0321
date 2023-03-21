<template>

    <v-card outlined>
        <v-card-title>
            Orderstatus # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Orderid" v-model="item.orderid" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Orderstatus" v-model="item.orderstatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Cookstatus" v-model="item.cookstatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Deliverystatus" v-model="item.deliverystatus" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'OrderstatusViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/orderstatuses/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

