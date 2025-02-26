package boj;


// https://www.acmicpc.net/problem/24900
public class Prob24900 {
    public static void main(String[] args) {
        System.out.println("""
                                                                           :8DDDDDDDDDDDDDD$.                                          \s
                                                                      DDDNNN8~~~~~~~~~~=~7DNNDNDDDNNI                                  \s
                                                                  ?NNDD=~=~~~~~~~~~~~~~~~~~=~~==~=INNDNN7                              \s
                                                               +NDDI~~~~~~~~~~~~~~~~~~~~~~~=~~========~ODND+                           \s
                                                            :NND~~~~~~~~~~~~~~~~~~~~~~~~~~~=~~============7NDN                         \s
                                                          $DD$~~~~~~~~~~~~~~~~~~~~~~~~~~~~~=~~==============~DNN                       \s
                                                        $DD=~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~=~~=================NND                     \s
                                                       ND7~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~=~~===================DD7                   \s
                                                     ~DD=~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~=======================8DN.                 \s
                                                    8DO~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~=========================DD                 \s
                                                   8N~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~=~~=======================DN                \s
                                                  NN::::::::~~~~~~~~~~~=~~~~~~~~~~~~~~~~~~~=~~========================DDO              \s
                                                 $D$:::::::::::::::~~~~DD~~~~~~~~~~~~~~~~~~=~~=========================DN.             \s
                                                 D8:::::::::::::::::::DN=::~~~~~~~~~~~~~~~~=~~======================~~:~DN             \s
                                                DN:::::::::::::::::::ONO::::::::::::::::::::~~~~~~~~~~~~:::::::::::::::::DN            \s
                                               DN::::::::::::::::::::NN.:::::::::::::::::::::::::::DN::::::::::::::::::::$DO           \s
                                               DD:::::::::::::::::::DNI:::::::::::::::::::::::::::::D=::::::::::::::::::::NN           \s
                                              NN~~~~:::::$N?:::::::.NN::::::::::::::::::::::::::::::ND.:::::::::::::::::::+N8          \s
                                              N7~~~~~~~~OD7::::::::~DD::::::::::::::::::::::::::::::~D$::::::::::::::::::::DN          \s
                                             NN~~~~~~~~IDZ~~~~~::::DN~:::::::::::::::::::::::::::::::DN::::::::::::::::::::=N~         \s
                                             DD~~~~~~~~NN~~~~~~~~~=NN::::::::::::::::::::::::::::::::DN:::::::::::::::~~====NN         \s
                                            8D~~~~~~~~ND~~~~~~~~~~~ND~~~~~~~~:::::::::::::::::::::::::N7:::~~===============NN         \s
                                            DD~~~~~~~ON+~~~~~~~~~~~ND~~~~~~~~~~~~~~~~~~~=+NZ==========NN====================~ND        \s
                               :DD7   DNDD. N8~~~~~~~NN~~~~~~~~~~DDND~~~~~~~~~~~~~~~~~~~~ND~~=========DD=====================ND        \s
                               N~:DDNNN .8NDN~~~~~~~$D=~~~~~~~~+ND.DD~~~~~~~~~~~~~~~~~~~=DD~~=========~D+====================DN        \s
                              :D     .  ..~ND~~~~~~~NN~~~~~~~+NN$..ND~~~~~~~~~~~~~~~~~~~7N=~~=========~ND=======~============ON        \s
                              NN       ...:N?~~~~~~~N=~~~~~NNNI.. .7D+~~~~~~~~~~~~~~~~~=8NN~~==========NN=======N============$N        \s
                         N  ODN       ....DN~~~~~~~DD=8NNND$..     .DD~~~=~~~~~~~~~~~~~=NNDD=~=========8D~======NN===========~N$       \s
                    N? =NN  ND      .....NND~~~~~~~DDNN:...        .ND=~DNN~~~~~~~~~~~~=DN.DN~=========?N+======NN============ND       \s
                   $D? DN    DZ    ....ND8NN~~~~~~$D                .DD~NNDD~~~~~~~~~~~~D8..DN=========~DN======NN============DN       \s
                   DN ~N~   NN    ..:~NN..NZ~~~~~~DN                  NNN8.ND~~~~NDN?~~~DZ...7DD=======~NN======NN============DN       \s
                   ND DD    :DN.  ..ND$  .N?~~~~~=NNN                   . ..DDD$~N8OND8=N+   ..DDDZ~====NN======+D+===========ND       \s
                   NO         DD  ZDN    8NO~~~~~~NNN..DDDNN7               ...NND...:DDD:     .:.NDND=~DD======~DO===========DN       \s
                              DNDDN:.    DN~~~~~~=NNNN.ODNNNNDDNNO              ...     .         ...DNNNN=======ND===========DD       \s
                       INDN7    DD.     .DD~~~~~=IDND:.:~.....?DNDNN.                        ...... ....$D=======ND===========ND       \s
                       NN        ND.    8N=~~~~$ND::.:=~:.~=......=ND~                 .NNNNNNNNNNNNNNN.~N+======NN===========DN       \s
                       $DD        DN:   DD~~~~7NO...~==.:~~:.....                      NNNND? ..::..7NZ.:N?======8D~==========ZN       \s
                       DN?     ~D: DND.?D~~~~~DD....~:.~=~.......                            ....~=:.:~..ND======~N$==========~DO      \s
                       ND    ..DD.  .DNDN=~~~~DI.......:.........                           ....=~..~~~..DN======~DD===========NN      \s
                       DDD  :.:DD.  . DDI~~~~~ND................        .DNNNNNNNNNN7      ....=~:.:~~...NN=======ND===========?D~     \s
                       8D. ...OD..    DD~~~~~~+ND ............          NN:~::::~~~8N      ........~~...:ND=======DN============NN     \s
                       DDI:...ND     .D7~~~~~~~7NN ..........           ID8::::::::8D      .............:DN=======ON============NN     \s
                        ~NNND.N=.   .NN~~~~~~~~~NDN8                       ~::::::~N8       .............DN========D=============NI    \s
                               DDNNN.ND~~~~~~~~DD =DND                                       ............DN========N+~===========NN    \s
                                   ~:N=~~~~~~~~DD   .DDDD                                       ........ NN========DD============8D    \s
                                    8N~~~~~~~~~ND    . .7NDDD? .                                      .8DDN========NN=============D:   \s
                                    DD~~~~~~~~~DND:         IDNNND$.                           .+DNNNNDNIDN========DD=============DD   \s
                                    ND~~~~~~~~ZN 7DD .. .:DDNDDNNDNNNNDDNDND8$?===+$8DDNNNDDDDDN8I~DN====8N========NN=============NN   \s
                                    DD~~~~~~~~8N   DD.  .NN~~~~.~~=DNDNO.:7ODDDDNNDD8DDDND=~~~ =~~~ON====8N========DN=============DN   \s
                                    ND~~~~~~~~DN    ZDD  DN~~~ ~~~~~=.7DDD+.......8NNN==~~~~~ ~~~~~ONN$==DN========8N=============ON   \s
                                    ND~8N~=~~~ZN      DDODN=~.~~~~~=.~~~~INDNNNNDNN~~~~~~~~:~~~~~~~DN~ND=DN========DD=========~ND=8N   \s
                                    IN=NDDI~~~~D8       DNN::~~~~~.~~~~~=.~~ND~~ND~~~~~~~~.~~~~~~~~NN  NDNN====ND==ND~D?======DNN=ND   \s
                                     DNNI8ND=~~DN:       ZN=~~~~~ ~~~~~.~~~~DD~=DD~~~~~~~ ~~~~~~~=.ND. . ND===DNDD=NDDNN=====8NZDDDN   \s
                                      NND  IDNDNNN+       D+~~~:~~~~~~ ~~~~~DDNNN+~~~~~~~~~~~~~~:=?N7   .ND=~ND  DNNN~ID====ND7 NNN    \s
                                       ID                 ND~~ ~~~~~:.~~~7DDN7IDNN==~~ ~~~~~~~~ ~~DN   .:N?DDDDD NND  8N~=DDD  ZNN     \s
                                                          NN~:~~~~~ =7DDDD+8N  :N8DDZ.~~~~~~~~.~~~DD.   NDD+ . DN=     OND+            \s
                                                          DND~~~=8DNDDZ=~~ ND   NN~INND~~~~~.~~~~ND .    .    ..IDD                    \s
                                                         DDNNNDNNN+~~~~~~.7N.    ND~~~NDDI~ ~~~~=NNN             .DDI                  \s
                                                        DN=~~~~.=~~~~~~ ~~DN     +N+~~~~+DNDD~~~NNNND.            ..ND                 \s
                                                         DDI~~ ~~~~~~~ ~~~ND..  ..ND~~~~:~~~DNDNNNN+            ..7O8ND+               \s
                                                          .DND=~~~~=::~~=NN.   . . 8D~~.~~~~~~=DN$ODNDNDNNNDNNNNND8+~..                \s
                                                             8DNNI=.~~~~=NDDNNNNDDNDNN.~~~~~IDDNDND7:.                                 \s
                                                                ?DNNDD?~DD          ~NN~~=NDD$                                         \s
                                                                     :DDD.            NNNN=                                            \s
                """);
    }
}
