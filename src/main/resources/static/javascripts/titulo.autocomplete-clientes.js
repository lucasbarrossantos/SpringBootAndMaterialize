var Financeiro = Financeiro || {};

Financeiro.AutoComplete = (function () {

    function AutoComplete() {

    }

    AutoComplete.prototype.iniciar = function () {
        $.ajax({
            type: 'GET',
            url: '/entidades/filtro?nome=',
            success: function(response) {
                var entidades = response;
                var sugestaoDeEntidade = {};
                for (var i = 0; i < entidades.length; i++) {
                    sugestaoDeEntidade[entidades[i].nome] = entidades[i].flag;
                }

                $('input.autocomplete').autocomplete({
                    data: sugestaoDeEntidade,
                    limit: 5,
                    minLength: 2,
                    onAutocomplete: function (texto) {
                        sendItem(texto);
                    }
                });

                function sendItem(texto) {
                    var registrosEncontrados = entidades;
                    var codigo = 0;
                    var novo =  registrosEncontrados.filter(function (obj) {
                        if (obj.nome === texto){
                            codigo = obj.codigo;
                        }
                    });

                    if(codigo > 0){
                        var entidadeInput = $('#entidade-atualizada');
                        entidadeInput.attr('value', codigo);
                    }
                }
            }
        });
    };

    return AutoComplete;

}());

$(function () {
    var autocomplete = new Financeiro.AutoComplete();
    autocomplete.iniciar();
});
