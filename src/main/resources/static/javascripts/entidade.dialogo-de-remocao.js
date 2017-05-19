var Entidade = Entidade || {};

Entidade.DialogoDeRemocao = (function () {

    function Remover() {
        this.modal = $('#modal-excluir-entidade');
        this.botaoRemover = $('.js-remover-entidade-btn');
        this.alertError = $('#erro');
        this.alertInfo = $('#info');
    }

    Remover.prototype.iniciar = function () {
        this.botaoRemover.on('click', onModalShow.bind(this));
        this.alertError.on('dblclick', onDoubleClickErro);
        this.alertInfo.on('dblclick', onDoubleClickInfo);
    };
    
    function onModalShow(evento) {
        evento.preventDefault();
        var button = $(evento.currentTarget);
        var codigo = button.data('codigo');
        var nome = button.data('nome');
        var form = this.modal.find('form');
        var action = form.data('url-base');
        if (!action.endsWith('/')) {
            action += '/';
        }

        form.attr('action', action + codigo);

        this.modal.find('.modal-content span').html(
            'Tem certeza que deseja excluir <strong>'
            + nome + '</strong> ?');
    }

    function onDoubleClickErro(evento) {
        $(this).remove(); // Remove o alert
    }

    function onDoubleClickInfo() {
        $(this).remove(); // Remove o alert
    }


    return Remover;

}());

$(function () {

    var removerEntidade = new Entidade.DialogoDeRemocao();
    removerEntidade.iniciar();

});