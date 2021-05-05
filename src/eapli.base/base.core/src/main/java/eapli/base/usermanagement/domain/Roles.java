package eapli.base.usermanagement.domain;

/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */


import eapli.base.gestaoservicosrh.domain.TipoUtilizador;

public final class Roles {
    /**
     * RRH
     */
    public static final TipoUtilizador RRH = TipoUtilizador.valueOf("RESPONSAVEL_RECURSOS_HUMANOS");
    /**
     * Gestor de Serviço
     */
    public static final TipoUtilizador CLIENT_USER = TipoUtilizador.valueOf("CLIENT_USER");
    /**
     * Base Administrator
     */
    public static final TipoUtilizador ADMIN = TipoUtilizador.valueOf("ADMIN");
    /**
     *  Gestor Servico
     */
    public static final TipoUtilizador GESTOR_SERVICO = TipoUtilizador.valueOf("GESTOR_SERVICO");
    /**
     * Colaborador
     */
    public static final TipoUtilizador COLABORADOR = TipoUtilizador.valueOf("COLABORADOR");

    /**
     * get available role types for adding new users
     *
     * @return
     */
    public static TipoUtilizador[] nonUserValues() {
        return new TipoUtilizador[] { ADMIN, COLABORADOR, GESTOR_SERVICO, RRH };
    }

    public boolean isCollaborator(final TipoUtilizador role) {
        return role != CLIENT_USER;
    }
}
