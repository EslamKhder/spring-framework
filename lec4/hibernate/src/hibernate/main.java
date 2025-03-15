CREATE OR REPLACE FORCE VIEW PV_GET_E_CERTIFICATE
(
   ID,
   TRAFFIC_FILE_ID,
   REFERENCE_NO,
   TRS_ID,
   VLE_ID,
   CERTIFICATE_TYPE_A,
   CERTIFICATE_TYPE_E,
   SVC_CODE,
   STATUS,
   RELATED_TO_A,
   RELATED_TO_E,
   ISSUE_DATE,
   EXPIRY_DATE,
   LICENSE_APPLICATION_ID,
   STATUS_DESC_A,
   STATUS_DESC_E,
   REMARKS,
   JOURNEY_REF_NO
)
   BEQUEATH DEFINER
AS
   SELECT ROWNUM AS ID,
         RESULT."TRAFFIC_FILE_ID",
         RESULT."REFERENCE_NO",
         RESULT."TRS_ID",
         RESULT."VLE_ID",
         RESULT."CERTIFICATE_TYPE_A",
         RESULT."CERTIFICATE_TYPE_E",
         RESULT."SVC_CODE",
         RESULT."STATUS",
         RESULT."RELATED_TO_A",
         RESULT."RELATED_TO_E",
         RESULT."ISSUE_DATE",
         RESULT."EXPIRY_DATE",
         RESULT."LICENSE_APPLICATION_ID",
         RESULT."STATUS_DESC_A",
         RESULT."STATUS_DESC_E",
         RESULT."REMARKS",
         RESULT."JOURNEY_REF_NO"
    FROM (SELECT TF.ID TRAFFIC_FILE_ID,
                 DPL.REF_NO REFERENCE_NO,
                 TRS.ID TRS_ID,
                 PKG_SDDI.F_GET_TRS_ENTITY_ID (TRS.ID) VLE_ID,
                TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (TRS.ID, TRS.SVC_CODE_DRL).AR_VAL CERTIFICATE_TYPE_A,
                TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (TRS.ID, TRS.SVC_CODE_DRL).EN_VAL CERTIFICATE_TYPE_E,
                 TRS.SVC_CODE_DRL SVC_CODE,
                 1 STATUS,
                 PRS.NAME_A RELATED_TO_A,
                 PRS.NAME_E RELATED_TO_E,
                 DPL.REF_DATE ISSUE_DATE,
                 NULL EXPIRY_DATE,
                 NULL LICENSE_APPLICATION_ID,
                 'فعالة' STATUS_DESC_A,
                 'Valid' STATUS_DESC_E,
                 '' REMARKS,
                 '' JOURNEY_REF_NO
          FROM TF_STP_TRAFFIC_FILES   TF,
               TF_STP_PERSONS         PRS,
               TF_STP_TRANSACTIONS    TRS,
               TF_DRL_CERT_PRINT_LOGS DPL,
               TF_DRL_ISSUE_TW_CERTIFICATES TWC
          WHERE TF.TRAFFIC_NO = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE('PV_TRAFFIC_NO')
            AND TF.PRS_ID = PRS.ID
            AND TRS.PRS_ID = PRS.ID
            AND DPL.RELATED_TRS_ID = TRS.ID
            and TWC.TRS_ID = DPL.RELATED_TRS_ID
            AND TRS.SVC_CODE_DRL = 113
            AND DPL.TRS_CERT_TYPE = 26
            AND NOT EXISTS(SELECT 1 FROM TF_DRL_DRIVING_LICENSES WHERE TRF_ID = TF.ID)
          UNION
          SELECT * FROM (SELECT TF.ID TRAFFIC_FILE_ID,
                  DPL.REF_NO REFERENCE_NO,
                  TRS.ID TRS_ID,
                  NULL AS VLE_ID,
                  TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (TRS.ID, TRS.SVC_CODE_DRL).AR_VAL CERTIFICATE_TYPE_A,
                  TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (TRS.ID, TRS.SVC_CODE_DRL).EN_VAL CERTIFICATE_TYPE_E,
                  TRS.SVC_CODE_DRL SVC_CODE,
                  1 STATUS,
                  PRS.NAME_A RELATED_TO_A,
                  PRS.NAME_E RELATED_TO_E,
                  DPL.REF_DATE ISSUE_DATE,
                  NULL AS EXPIRY_DATE,
                  NULL AS LICENSE_APPLICATION_ID,
                  'فعالة' STATUS_DESC_A,
                  'Valid' STATUS_DESC_E,
                 '' REMARKS,
                 '' JOURNEY_REF_NO
             FROM TF_STP_TRAFFIC_FILES    TF,
                  TF_STP_PERSONS          PRS,
                  TF_STP_TRANSACTIONS     TRS,
                  TF_DRL_CERT_PRINT_LOGS  DPL,
                  TF_DRL_DRIVING_LICENSES DRL
            WHERE TF.TRAFFIC_NO = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE('PV_TRAFFIC_NO')
              AND TF.PRS_ID = PRS.ID
              AND TRS.PRS_ID = PRS.ID
              AND DPL.RELATED_TRS_ID = TRS.ID
              AND DRL.TRF_ID = TF.ID
              AND TRS.SVC_CODE_DRL = 107
              AND DPL.TRS_CERT_TYPE = 6
              AND DRL.LICENSE_STATUS = 9
              AND 1 = 2 -- TEMP Until enable the feature on UMS
              ORDER BY TRS.ID DESC)
              WHERE ROWNUM = 1
          UNION
          SELECT * FROM (SELECT TF.ID TRAFFIC_FILE_ID,
                   TO_CHAR(TRS.ID) REFERENCE_NO,
                   TRS.ID TRS_ID,
                   NULL AS VLE_ID,
                   TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (TRS.ID, TRS.SVC_CODE).AR_VAL CERTIFICATE_TYPE_A,
                   TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (TRS.ID, TRS.SVC_CODE).EN_VAL CERTIFICATE_TYPE_E,
                   TRS.SVC_CODE SVC_CODE,
                   1 STATUS,
                   PRS.NAME_A RELATED_TO_A,
                   PRS.NAME_E RELATED_TO_E,
                   CPL.CERTIFCATE_DATE ISSUE_DATE,
                   NULL AS EXPIRY_DATE,
                   NULL AS LICENSE_APPLICATION_ID,
                   'فعالة' STATUS_DESC_A,
                   'Valid' STATUS_DESC_E,
                   '' REMARKS,
                   '' JOURNEY_REF_NO
           FROM TF_STP_TRAFFIC_FILES          TF,
                TF_STP_PERSONS                PRS,
                TF_STP_TRANSACTIONS           TRS,
                TF_DTT_CERTIFICATE_PRINT_LOGS CPL
          WHERE TF.TRAFFIC_NO = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE('PV_TRAFFIC_NO')
            AND TF.PRS_ID = PRS.ID
            AND TRS.PRS_ID = PRS.ID
            AND CPL.RELATED_TRS_ID = TRS.ID
            AND TRS.SVC_CODE = 12
            AND CPL.TRS_TYPE = 2
            ORDER BY TRS.ID DESC)
            WHERE ROWNUM = 1
          UNION
          SELECT TRF.ID TRAFFIC_FILE_ID,
                 TO_CHAR(PPL.PERMIT_NO) REFERENCE_NO,
                 SPM.TRS_ID TRS_ID,
                 NULL VLE_ID,
                 PETY.NAME_A CERTIFICATE_TYPE_A,
                 PETY.NAME_E CERTIFICATE_TYPE_E,
                 ECR.SVC_CODE,
                 ECR.STATUS,
                 PRS.NAME_A RELATED_TO_A,
                 PRS.NAME_E RELATED_TO_E,
                 ECR.ISSUE_DATE,
                 ECR.EXPIRY_DATE,
                 SPM.PERMIT_TYPE LICENSE_APPLICATION_ID,
                 PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC ('TF_ECERTIFICATE_STATUS',ECR.STATUS) STATUS_DESC_A,
                 PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC_E ('TF_ECERTIFICATE_STATUS', ECR.STATUS) STATUS_DESC_E,
                 '' REMARKS,
                 '' JOURNEY_REF_NO
            FROM TF_STP_SP_PERMITS_PRINTING_LOG PPL,
                 TF_STP_ECERTIFICATES ECR,
                 TF_STP_TRANSACTIONS TRS,
                 TF_STP_SPECIAL_PERMITS SPM,
                 TF_STP_PERMIT_TYPES PETY,
                 TF_STP_TRAFFIC_FILES TRF,
                 TF_STP_PERSONS PRS,
                 TF_STP_ORGANIZATIONS ORG,
                 TF_DRL_DRIVING_LICENSES DLC,
                 TF_STP_PERMIT_CATEGORIES PEC,
                 TF_STP_PERMIT_TYPES PRY
           WHERE PPL.SPM_ID = SPM.ID
             AND PPL.ID = (SELECT MAX(PPL2.ID) FROM TF_STP_SP_PERMITS_PRINTING_LOG PPL2 WHERE PPL2.PERMIT_NO = SPM.PERMIT_NO)
             AND ECR.TRS_ID = SPM.TRS_ID
             AND TRS.ID = ECR.TRS_ID
             AND TRS.SVC_CODE_DRL IN (124,125)
             AND SPM.TRF_ID = TRF.ID
             AND SPM.PERMIT_TYPE = PETY.ID
             AND ORG.ID(+) = TRF.ORG_ID
             AND PRS.ID(+) = TRF.PRS_ID
             AND DLC.TRF_ID(+) = TRF.ID
             AND SPM.PEC_ID = PEC.ID(+)
             AND PRY.ID = PEC.PRY_ID
             AND TRF.TRAFFIC_NO = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
             AND TRUNC(ECR.EXPIRY_DATE) > TRUNC(SYSDATE)
             AND (SPM.PERMIT_TYPE   = nvL((select 4 from  TF_STP_SPECIAL_PERMITS SPM2 where SPM2.trf_id =TRF.ID and SPM2.PERMIT_TYPE =4),3)
                 OR SPM.PERMIT_TYPE   = nvL((select 2 from  TF_STP_SPECIAL_PERMITS SPM2 where SPM2.trf_id =TRF.ID and SPM2.PERMIT_TYPE =2),1)
                 OR SPM.PERMIT_TYPE   = nvL((select 10019 from  TF_STP_SPECIAL_PERMITS SPM2 where SPM2.trf_id =TRF.ID and SPM2.PERMIT_TYPE =10019),10038)
                 OR SPM.PERMIT_TYPE NOT IN (4,3,2,1,10019,10038) )
             AND SPM.PEC_ID in (28,916,23,449,1,1769,369,1770,3,2,22,4,89)
          UNION
            SELECT
                 TF.ID TRAFFIC_FILE_ID,
                 NVL (
                    NVL (
                       NVL (
                          TO_CHAR (
                             NVL (NVL (CPL_ID, DCR_ID), CPG.CERTIFICATE_NO)),
                          DPL.REF_NO),
                       DECODE (APP.PRS_ID,
                               NULL, NULL,
                               F_DB_GET_TRAFFIC_NO (APP.PRS_ID, NULL))),
                    PRL.PERMIT_NO)
                    REFERENCE_NO,
                 ECR.TRS_ID TRS_ID,
                 PKG_SDDI.F_GET_TRS_ENTITY_ID (trs.id) VLE_ID,
                 TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (ECR.TRS_ID, ECR.SVC_CODE).AR_VAL CERTIFICATE_TYPE_A,
                 TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (ECR.TRS_ID, ECR.SVC_CODE).EN_VAL CERTIFICATE_TYPE_E,
                 ECR.SVC_CODE,
                 ECR.STATUS,
                 NVL (F_DB_GET_ECR_ENTITY_DESC (ECR.ID, 'A'),
                      (SELECT NAME_A
                         FROM TF_STP_PERSONS
                        WHERE ID = TRS.PRS_ID))
                    RELATED_TO_A,
                 NVL (F_DB_GET_ECR_ENTITY_DESC (ECR.ID, 'E'),
                      (SELECT NAME_E
                         FROM TF_STP_PERSONS
                        WHERE ID = TRS.PRS_ID))
                    RELATED_TO_E,
                 ECR.ISSUE_DATE,
                 ECR.EXPIRY_DATE,
                 APP.ID LICENSE_APPLICATION_ID,
                 PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC (
                    'TF_ECERTIFICATE_STATUS',
                    ECR.STATUS)
                    STATUS_DESC_A,
                 PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC_E (
                    'TF_ECERTIFICATE_STATUS',
                    ECR.STATUS)
                    STATUS_DESC_E,
                   '' REMARKS,
                   '' JOURNEY_REF_NO
            FROM TF_STP_ECERTIFICATES ECR,
                 TF_STP_TRAFFIC_FILES TF,
                 TF_STP_TRANSACTIONS TRS,
                 TF_SPL_CERT_PRINT_LOGS CPG,
                 TF_DRL_CERT_PRINT_LOGS DPL,
                 TF_CML_PRINTING_LOGS CMP,
                 TF_DTT_LICENSE_APPLICATIONS APP,
                 TF_STP_SP_PERMITS_PRINTING_LOG PRL,
                 TF_STP_PERSONS PRS,
                 TF_STP_ORGANIZATIONS ORG
           WHERE     TRS.ID = ECR.TRS_ID
                 AND ECR.SPN_ID = PRL.ID(+)
                 AND ( (TRS.ORG_ID = ORG.ID) OR (TRS.PRS_ID = PRS.ID))
                 AND TF.PRS_ID = PRS.ID(+)
                 AND TF.ORG_ID = ORG.ID(+)
                 AND CPG_ID = CPG.ID(+)
                 AND DPL_ID = DPL.ID(+)
                 AND CMP_ID = CMP.ID(+)
                 AND TRS.APP_ID = APP.ID(+)
                 AND TF.TRAFFIC_NO = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
                 AND ECR.STATUS IN (1, 2, 3)
                 AND TRS.STATUS = 3
                 AND TRUNC(ECR.EXPIRY_DATE) > TRUNC(SYSDATE)
                 AND ECR.SVC_CODE NOT IN (206,
                                          207,
                                          205,
                                          240,
                                          247,
                                          212,
                                          213,
                                          214,
                                          215,
                                          216,
                                          225,
                                          226,
                                          227,
                                          241)
                AND TRS.SVC_CODE_DRL NOT IN (124,125)
                AND ECR.CREATED_BY != 'CLS_USER'
          UNION
              SELECT
                  TF.ID TRAFFIC_FILE_ID,
                  TO_CHAR(CMP.REF_NO) REFERENCE_NO,
                  ECR.TRS_ID TRS_ID,
                  NULL VLE_ID,
                  (
                  SELECT JSON_VALUE(SERV.NAME, '$.ar')
                  FROM   CLS_NOC.SCT_SERVICE SERV,
                  TRAFFIC.TF_DT_SERVICES DSER
                  WHERE  DSER.SVC_CODE = ECR.SVC_CODE
                  AND    DSER.DT_SVC_CODE = SERV.CODE
                  ) CERTIFICATE_TYPE_A,
                  (
                  SELECT JSON_VALUE(SERV.NAME, '$.en')
                  FROM   CLS_NOC.SCT_SERVICE SERV,
                  TRAFFIC.TF_DT_SERVICES DSER
                  WHERE  DSER.SVC_CODE = ECR.SVC_CODE
                  AND    DSER.DT_SVC_CODE = SERV.CODE
                  ) CERTIFICATE_TYPE_E,
                  ECR.SVC_CODE SVC_CODE,
                  ECR.STATUS STATUS,
                  ORG.NAME_A RELATED_TO_A,
                  ORG.NAME RELATED_TO_E,
                  ECR.ISSUE_DATE ISSUE_DATE,
                  ECR.EXPIRY_DATE EXPIRY_DATE,
                  NULL LICENSE_APPLICATION_ID,
                  PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC (
                  'TF_ECERTIFICATE_STATUS',
                  ECR.STATUS)
                  STATUS_DESC_A,
                  PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC_E (
                  'TF_ECERTIFICATE_STATUS',
                  ECR.STATUS)
                  STATUS_DESC_E,
                  '' REMARKS,
                  DECODE(ECR.SVC_CODE, '816', ORI.TRADE_LICENSE, '') JOURNEY_REF_NO
              FROM TF_STP_ECERTIFICATES ECR,
                  TF_STP_TRAFFIC_FILES TF,
                  TF_CML_PRINTING_LOGS CMP,
                  TF_STP_ORGANIZATIONS ORG,
                  TF_STP_ORG_REGISTRATION_INFOS ORI
              WHERE TF.ID = ECR.TRF_ID
                AND TF.ORG_ID = ORG.ID
                AND CMP_ID = CMP.ID
                AND TF.TRAFFIC_NO = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
                AND ECR.STATUS IN (1, 2, 3)
                AND ORG.ID = ORI.ORG_ID
--                 AND TRUNC(ECR.EXPIRY_DATE) > TRUNC(SYSDATE)
                AND ECR.CREATED_BY = 'CLS_USER'
          UNION
          SELECT
                 TF.ID TRAFFIC_FILE_ID,
                 TO_CHAR (CPL.ID) REFERENCE_NO,
                 TRS.ID TRS_ID,
                 bkt.vle_id VLE_ID,
                 TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (TRS.ID, TRS.SVC_CODE_VHL).AR_VAL CERTIFICATE_TYPE_A,
                 TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (TRS.ID, TRS.SVC_CODE_VHL).EN_VAL CERTIFICATE_TYPE_E,
                 TRS.SVC_CODE_VHL SVC_CODE,
                 1 STATUS,
                 F_GET_TRF_OWNER_NAME_A (tf.id) RELATED_TO_A,
                 F_GET_TRF_OWNER_NAME_E (tf.id) RELATED_TO_E,
                 CPL.REF_DATE ISSUE_DATE,
                 NULL EXPIRY_DATE,
                 NULL LICENSE_APPLICATION_ID,
                 PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC (
                    'TF_ECERTIFICATE_STATUS',
                    1)
                    STATUS_DESC_A,
                 PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC_E (
                    'TF_ECERTIFICATE_STATUS',
                    1)
                    STATUS_DESC_E,
                   '' REMARKS,
                   '' JOURNEY_REF_NO
            FROM TF_VHL_BOOKLETS BKT,
                 TF_VHL_CERTIFICATE_PRINT_LOGS CPL,
                 TF_STP_TRAFFIC_FILES TF,
                 TF_STP_TRANSACTIONS TRS
           WHERE     TRS.ID = CPL.RELATED_TRS_ID
                 AND TRS.ID = BKT.RELATED_TRS_ID
                 AND BKT.TRF_ID = TF.ID
                 AND TRS.STATUS = 3
                 AND TRS.SVC_CODE_vhl IN (206,
                                          207,
                                          205,
                                          240,
                                          247)
                 AND bkt.NEW_OWNER IS NULL
                 AND DECODE(TRS.SVC_CODE_VHL, 205, VLS_SELL_VEHICLE_JOURNEY.F_IS_VIEW_POSS_CERT(TRS.ID), 2) = 2
                 AND bkt.trs_start_date >=
                        (SELECT MAX (bkt2.trs_start_date)
                           FROM TF_VHL_BOOKLETS bkt2, tf_vhl_vehicles vle
                          WHERE bkt2.vle_id = vle.id AND bkt.vle_id = vle.id)
                 AND TF.TRAFFIC_NO = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
                -- AND NVL2 (trs.org_id, trs.org_id, trs.prs_id) =
                --        NVL2 (trs.org_id, tf.org_id, tf.prs_id)
          UNION
          SELECT
                 TF.ID TRAFFIC_FILE_ID,
                 TO_CHAR (CPL.ID) REFERENCE_NO,
                 TRS.ID TRS_ID,
                 bkt.vle_id VLE_ID,
                 TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (TRS.ID, TRS.SVC_CODE_VHL).AR_VAL CERTIFICATE_TYPE_A,
                 TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (TRS.ID, TRS.SVC_CODE_VHL).EN_VAL CERTIFICATE_TYPE_E,
                 TRS.SVC_CODE_VHL SVC_CODE,
                 (CASE
                     WHEN     cpl.trs_type IN (9)
                          AND TRUNC (cpl.REF_DATE) + 15 <= TRUNC (SYSDATE)
                     THEN
                        2
                     WHEN     cpl.trs_type IN (8)
                          AND TRUNC (cpl.REF_DATE) + 30 <= TRUNC (SYSDATE)
                     THEN
                        2
                     WHEN     cpl.trs_type IN (13)
                          AND ADD_MONTHS (TRUNC (cpl.REF_DATE), 6) <=
                                 TRUNC (SYSDATE)
                     THEN
                        2
                     ELSE
                        1
                  END)
                    STATUS,
                 F_GET_TRF_OWNER_NAME_A (tf.id) RELATED_TO_A,
                 F_GET_TRF_OWNER_NAME_E (tf.id) RELATED_TO_E,
                 CPL.REF_DATE ISSUE_DATE,
                 (CASE
                     WHEN cpl.trs_type IN (9) THEN TRUNC (cpl.REF_DATE) + 15
                     WHEN cpl.trs_type IN (8) THEN TRUNC (cpl.REF_DATE) + 30
                     ELSE NULL
                  END)
                    EXPIRY_DATE,
                 NULL LICENSE_APPLICATION_ID,
                 (CASE
                     WHEN     cpl.trs_type IN (9)
                          AND TRUNC (cpl.REF_DATE) + 15 <= TRUNC (SYSDATE)
                     THEN
                        PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC (
                           'TF_ECERTIFICATE_STATUS',
                           2)
                     WHEN     cpl.trs_type IN (8)
                          AND TRUNC (cpl.REF_DATE) + 30 <= TRUNC (SYSDATE)
                     THEN
                        PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC (
                           'TF_ECERTIFICATE_STATUS',
                           2)
                     WHEN     cpl.trs_type IN (13)
                          AND ADD_MONTHS (TRUNC (cpl.REF_DATE), 6) <=
                                 TRUNC (SYSDATE)
                     THEN
                        PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC (
                           'TF_ECERTIFICATE_STATUS',
                           2)
                     ELSE
                        PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC (
                           'TF_ECERTIFICATE_STATUS',
                           1)
                  END)
                    STATUS_DESC_A,
                 (CASE
                     WHEN     cpl.trs_type IN (9)
                          AND TRUNC (cpl.REF_DATE) + 15 <= TRUNC (SYSDATE)
                     THEN
                        PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC_E (
                           'TF_ECERTIFICATE_STATUS',
                           2)
                     WHEN     cpl.trs_type IN (8)
                          AND TRUNC (cpl.REF_DATE) + 30 <= TRUNC (SYSDATE)
                     THEN
                        PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC_E (
                           'TF_ECERTIFICATE_STATUS',
                           2)
                     WHEN     cpl.trs_type IN (13)
                          AND ADD_MONTHS (TRUNC (cpl.REF_DATE), 6) <=
                                 TRUNC (SYSDATE)
                     THEN
                        PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC_E (
                           'TF_ECERTIFICATE_STATUS',
                           2)
                     ELSE
                        PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC_E (
                           'TF_ECERTIFICATE_STATUS',
                           1)
                  END)
                    STATUS_DESC_E,
                   '' REMARKS,
                   '' JOURNEY_REF_NO
            FROM TF_VHL_BOOKLETS BKT,
                 TF_VHL_CERTIFICATE_PRINT_LOGS CPL,
                 TF_STP_TRAFFIC_FILES TF,
                 TF_STP_TRANSACTIONS TRS
           WHERE     TRS.ID = CPL.RELATED_TRS_ID
                 AND CPL.BKT_ID = BKT.ID
                 AND BKT.TRF_ID = TF.ID
                 AND TRS.STATUS = 3
                 AND (   (TRS.SVC_CODE_vhl IN (212,
                                               213,
                                               214,
                                               216,
                                               225,
                                               226))
                      OR (TRS.SVC_CODE_vhl IN (227) AND cpl.trs_type in (24)))
                 AND NVL2 (trs.org_id, trs.org_id, trs.prs_id) =
                        NVL2 (trs.org_id, tf.org_id, tf.prs_id)
                 AND TF.TRAFFIC_NO = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
          UNION
          SELECT
                 TF.ID TRAFFIC_FILE_ID,
                 TO_CHAR (CPL.ID) REFERENCE_NO,
                 TRS.ID TRS_ID,
                 CPL.vle_id VLE_ID,
                 TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (TRS.ID, TRS.SVC_CODE_VHL).AR_VAL CERTIFICATE_TYPE_A,
                 TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (TRS.ID, TRS.SVC_CODE_VHL).EN_VAL CERTIFICATE_TYPE_E,
                 TRS.SVC_CODE_VHL SVC_CODE,
                 (CASE
                     WHEN     cpl.trs_type IN (9, 10)
                          AND TRUNC (cpl.REF_DATE) + 15 <= TRUNC (SYSDATE)
                     THEN
                        2
                     ELSE
                        1
                  END)
                    STATUS,
                 prs.name_A RELATED_TO_A,
                 prs.name_E RELATED_TO_E,
                 CPL.REF_DATE ISSUE_DATE,
                 (CASE
                     WHEN cpl.trs_type IN (9, 10)
                     THEN
                        TRUNC (cpl.REF_DATE) + 15
                     ELSE
                        NULL
                  END)
                    EXPIRY_DATE,
                 NULL LICENSE_APPLICATION_ID,
                 (CASE
                     WHEN     cpl.trs_type IN (9, 10)
                          AND TRUNC (cpl.REF_DATE) + 15 <= TRUNC (SYSDATE)
                     THEN
                        PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC (
                           'TF_ECERTIFICATE_STATUS',
                           2)
                     ELSE
                        PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC (
                           'TF_ECERTIFICATE_STATUS',
                           1)
                  END)
                    STATUS_DESC_A,
                 (CASE
                     WHEN     cpl.trs_type IN (9, 10)
                          AND TRUNC (cpl.REF_DATE) + 15 <= TRUNC (SYSDATE)
                     THEN
                        PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC_E (
                           'TF_ECERTIFICATE_STATUS',
                           2)
                     ELSE
                        PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC_E (
                           'TF_ECERTIFICATE_STATUS',
                           1)
                  END)
                    STATUS_DESC_E,
                   '' REMARKS,
                   '' JOURNEY_REF_NO
            FROM TF_VHL_CERTIFICATE_PRINT_LOGS CPL,
                 TF_STP_TRAFFIC_FILES TF,
                 TF_STP_TRANSACTIONS TRS,
                 tf_stp_persons prs
           WHERE     TRS.ID = CPL.RELATED_TRS_ID
                 AND trs.prs_id = prs.id
                 AND prs.id = tf.prs_id
                 AND TRS.STATUS = 3
                 AND cpl.trs_type IN (22,
                                      23,
                                      30,
                                      9,
                                      10)
                 AND cpl.bkt_id IS NULL
                 AND cpl.vle_id IS NULL
                 AND trs.prs_id = tf.prs_id
                 AND TF.TRAFFIC_NO = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
          UNION
          SELECT
                 TF.ID TRAFFIC_FILE_ID,
                 TO_CHAR (CPL.ID) REFERENCE_NO,
                 TRS.ID TRS_ID,
                 CPL.vle_id VLE_ID,
                 TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (TRS.ID, TRS.SVC_CODE_VHL).AR_VAL CERTIFICATE_TYPE_A,
                 TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (TRS.ID, TRS.SVC_CODE_VHL).EN_VAL CERTIFICATE_TYPE_E,
                 TRS.SVC_CODE_VHL SVC_CODE,
                 (CASE
                     WHEN     cpl.trs_type IN (9, 10)
                          AND TRUNC (cpl.REF_DATE) + 15 <= TRUNC (SYSDATE)
                     THEN
                        2
                     ELSE
                        1
                  END)
                    STATUS,
                 ORG.NAME_A RELATED_TO_A,
                 ORG.NAME RELATED_TO_E,
                 CPL.REF_DATE ISSUE_DATE,
                 (CASE
                     WHEN cpl.trs_type IN (9, 10)
                     THEN
                        TRUNC (cpl.REF_DATE) + 15
                     ELSE
                        NULL
                  END)
                    EXPIRY_DATE,
                 NULL LICENSE_APPLICATION_ID,
                 (CASE
                     WHEN     cpl.trs_type IN (9, 10)
                          AND TRUNC (cpl.REF_DATE) + 15 <= TRUNC (SYSDATE)
                     THEN
                        PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC (
                           'TF_ECERTIFICATE_STATUS',
                           2)
                     ELSE
                        PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC (
                           'TF_ECERTIFICATE_STATUS',
                           1)
                  END)
                    STATUS_DESC_A,
                 (CASE
                     WHEN     cpl.trs_type IN (9, 10)
                          AND TRUNC (cpl.REF_DATE) + 15 <= TRUNC (SYSDATE)
                     THEN
                        PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC_E (
                           'TF_ECERTIFICATE_STATUS',
                           2)
                     ELSE
                        PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC_E (
                           'TF_ECERTIFICATE_STATUS',
                           1)
                  END)
                    STATUS_DESC_E,
                   '' REMARKS,
                   '' JOURNEY_REF_NO
            FROM TF_VHL_CERTIFICATE_PRINT_LOGS CPL,
                 TF_STP_TRAFFIC_FILES TF,
                 TF_STP_TRANSACTIONS TRS,
                 tf_stp_organizations org
           WHERE     TRS.ID = CPL.RELATED_TRS_ID
                 AND trs.org_id = org.id
                 AND org.id = tf.org_id
                 AND TRS.STATUS = 3
                 AND cpl.trs_type IN (22,
                                      23,
                                      30,
                                      9,
                                      10)
                 AND cpl.bkt_id IS NULL
                 AND cpl.vle_id IS NULL
                 AND TF.TRAFFIC_NO = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
                 AND trs.org_id = tf.org_id
         UNION
   		  select
			       TF.ID TRAFFIC_FILE_ID,
			       TO_CHAR(JSON_VALUE(PRODUCT_DOCUMENT, '$.referenceNumber' RETURNING NUMBER NULL ON ERROR)) REFERENCE_NO,
			       NULL AS TRS_ID,
			       NULL AS VLE_ID,
			       'اتفاقية شراء مركبة' CERTIFICATE_TYPE_A,
			       'Sell Vehicle Purchase Agreement' CERTIFICATE_TYPE_E,
			       2022 SVC_CODE,
			       2 AS STATUS,
			       F_GET_TRF_OWNER_NAME_A (tf.id) RELATED_TO_A,
			       F_GET_TRF_OWNER_NAME_E (tf.id) RELATED_TO_E,
			       to_date(JSON_VALUE(PRODUCT_DOCUMENT, '$.issueDate' RETURNING varchar2(100) NULL ON ERROR),'yyyy-mm-dd') ISSUE_DATE,
			       NULL EXPIRY_DATE,
			       NULL LICENSE_APPLICATION_ID,
			       'فعالة' STATUS_DESC_A,
			       'Valid' STATUS_DESC_E,
                   '' REMARKS,
                   '' JOURNEY_REF_NO
			 from vls_vehicle.SELL_PURCHASE_AGREEMENT SEPA,
			      TF_STP_TRAFFIC_FILES TF
			where tf.traffic_no = JSON_VALUE(PRODUCT_DOCUMENT, '$.buyerDetails.summaryInfo.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR)
			  AND JSON_VALUE(PRODUCT_DOCUMENT, '$.buyerDetails.summaryInfo.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR) = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
	  UNION
	    select
			       TF.ID TRAFFIC_FILE_ID,
			       TO_CHAR(JSON_VALUE(PRODUCT_DOCUMENT, '$.referenceNumber' RETURNING NUMBER NULL ON ERROR)) REFERENCE_NO,
			       NULL AS TRS_ID,
			       NULL AS VLE_ID,
			       'اتفاقية شراء مركبة' CERTIFICATE_TYPE_A,
			       'Sell Purchase Agreement' CERTIFICATE_TYPE_E,
			       2022 SVC_CODE,
			       2 AS STATUS,
			       F_GET_TRF_OWNER_NAME_A (tf.id) RELATED_TO_A,
			       F_GET_TRF_OWNER_NAME_E (tf.id) RELATED_TO_E,
			       to_date(JSON_VALUE(PRODUCT_DOCUMENT, '$.issueDate' RETURNING varchar2(100) NULL ON ERROR),'yyyy-mm-dd') ISSUE_DATE,
			       NULL EXPIRY_DATE,
			       NULL LICENSE_APPLICATION_ID,
			       'فعالة' STATUS_DESC_A,
			       'Valid' STATUS_DESC_E,
                   '' REMARKS,
                   '' JOURNEY_REF_NO
			 from vls_vehicle.SELL_PURCHASE_AGREEMENT SEPA,
			      TF_STP_TRAFFIC_FILES TF
			where tf.traffic_no = JSON_VALUE(PRODUCT_DOCUMENT, '$.sellerDetails.summaryInfo.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR)
			  AND JSON_VALUE(PRODUCT_DOCUMENT, '$.sellerDetails.summaryInfo.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR) = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
		UNION
			select DISTINCT
			       TF.ID TRAFFIC_FILE_ID,
			       TO_CHAR(JSON_VALUE(PRODUCT_DOCUMENT, '$.referenceNumber' RETURNING NUMBER NULL ON ERROR)) REFERENCE_NO,
			       NULL AS TRS_ID,
			       NULL AS VLE_ID,
			       'اتفاقية شراء مركبة' CERTIFICATE_TYPE_A,
			       'Sell Purchase Agreement' CERTIFICATE_TYPE_E,
			       2022 SVC_CODE,
			       2 AS STATUS,
			       F_GET_TRF_OWNER_NAME_A (tf.id) RELATED_TO_A,
			       F_GET_TRF_OWNER_NAME_E (tf.id) RELATED_TO_E,
			       to_date(JSON_VALUE(PRODUCT_DOCUMENT, '$.issueDate' RETURNING varchar2(100) NULL ON ERROR),'yyyy-mm-dd') ISSUE_DATE,
			       NULL EXPIRY_DATE,
			       NULL LICENSE_APPLICATION_ID,
			       'فعالة' STATUS_DESC_A,
			       'Valid' STATUS_DESC_E,
                   '' REMARKS,
                   '' JOURNEY_REF_NO
			 from vls_vehicle.SELL_PURCHASE_AGREEMENT SEPA,
			      TF_STP_TRAFFIC_FILES TF
			where tf.traffic_no = JSON_VALUE(PRODUCT_DOCUMENT, '$.dealerDetails.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR)
			  AND JSON_VALUE(PRODUCT_DOCUMENT, '$.dealerDetails.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR) = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
        UNION
			SELECT * FROM
                (SELECT TF.ID TRAFFIC_FILE_ID,
                        TO_CHAR(SCPE.PERMIT_NUMBER) AS REFERENCE_NO,
                        SCPE.PERMIT_NUMBER AS TRS_ID,
                        NULL AS VLE_ID,
                        'إصدار تصريح سكوتر' AS CERTIFICATE_TYPE_A,
                        'Issue Scooter Permit' AS CERTIFICATE_TYPE_E,
                        147 AS SVC_CODE,
                        1 AS STATUS,
                        PART.NAME_AR RELATED_TO_A,
                        PART.NAME_EN RELATED_TO_E,
                        SCPE.STATUS_DATE ISSUE_DATE,
                        NULL AS EXPIRY_DATE,
                        NULL AS LICENSE_APPLICATION_ID,
                        'فعالة' STATUS_DESC_A,
                        'Valid' STATUS_DESC_E
                        ,'' AS REMARKS,
                        APP.REFERENCE_NO AS JOURNEY_REF_NO
                    FROM TRAFFIC.TF_TRS_APPLICATION             APP,
                         TRAFFIC.TF_TRS_APPLICATION_PARTICIPANT PART,
                         TRAFFIC.TF_DRL_SCOOTER_PERMIT          SCPE,
                         TRAFFIC.TF_STP_TRAFFIC_FILES           TF
                   WHERE APP.ID = PART.APPLICATION_ID
                     AND APP.ID = SCPE.JOURNEY_ID
                     AND PART.TRAFFIC_NO = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE('PV_TRAFFIC_NO')
                     AND TF.TRAFFIC_NO = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE('PV_TRAFFIC_NO')
                   ORDER BY SCPE.ID DESC)
            WHERE ROWNUM = 1
			UNION
          SELECT TF.ID TRAFFIC_FILE_ID,
                 TO_CHAR (CPG.CERTIFICATE_NO) REFERENCE_NO,
                 TRS.ID TRS_ID, PKG_SDDI.F_GET_TRS_ENTITY_ID (TRS.ID) VLE_ID,
                 'ملكية رقم مميز'  CERTIFICATE_TYPE_A,
                 'Special Plate Ownership' CERTIFICATE_TYPE_E,
                 TRS.SVC_CODE_ACT   SVC_CODE, 2 STATUS, PRS.NAME_A RELATED_TO_A,
                 PRS.NAME_E   RELATED_TO_E,
                 TRS.STATUS_DATE ISSUE_DATE,
                 NULL EXPIRY_DATE,
                 NULL LICENSE_APPLICATION_ID,
                 'فعالة' STATUS_DESC_A,
                 'Valid' STATUS_DESC_E,
                   '' REMARKS,
                   '' JOURNEY_REF_NO
          FROM TF_STP_TRAFFIC_FILES        TF,
               TF_STP_TRANSACTIONS         TRS,
               TF_SPL_CERT_PRINT_LOGS      CPG,
               TF_STP_PERSONS              PRS,
               TF_STP_ORGANIZATIONS        ORG,
               TF_VHL_PLATES               PLT,
               TF_VHL_PLATE_CODES          PCD,
               TF_VHL_PLATE_CATEGORIES     PLC,
               TF_STP_TRANSACTION_SHIPMENTS STS
          WHERE ((TRS.ORG_ID = ORG.ID)
                OR (TRS.PRS_ID = PRS.ID))
                AND TF.PRS_ID = PRS.ID(+)
                AND TF.ORG_ID = ORG.ID(+)
                AND TRS.ID = CPG.TRS_ID
                AND CPG.TRF_ID = TF.ID
                AND TF.TRAFFIC_NO =
                    LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
                AND CPG.PLT_ID = PLT.ID
                AND PLT.PCD_ID = PCD.ID
                AND PCD.PLC_EMI_CODE = PLC.EMI_CODE
                AND PCD.PLC_CODE = PLC.CODE
                AND TRS.ID = STS.TRS_ID(+)
                AND PLC.IS_SPECIAL_PLATE = 2
                AND TRS.STATUS = 3
                AND TRS.SVC_CODE_ACT IN (401,403,402)
                AND PLT.TRF_ID = TF.ID

         UNION
            SELECT
                TF.ID TRAFFIC_FILE_ID,
                '' || JSON_VALUE(IVS.APPLICATION_CRITERIA,'$.parameters.paymentRefNo' RETURNING NUMBER NULL ON ERROR) REFERENCE_NO,
                JSON_VALUE(IVS.APPLICATION_CRITERIA,'$.parameters.paymentRefNo' RETURNING NUMBER NULL ON ERROR) AS TRS_ID,
                NULL VLE_ID,
                'تقرير حالة المركبة' CERTIFICATE_TYPE_A,
                'Vehicle Status Report' CERTIFICATE_TYPE_E,
                270 SVC_CODE,
                2 STATUS,
                F_GET_TRF_OWNER_NAME_A (tf.id) RELATED_TO_A,
                F_GET_TRF_OWNER_NAME_E (tf.id) RELATED_TO_E,
                TO_DATE(JSON_VALUE(IVS.APPLICATION_CRITERIA, '$.parameters.issueDate' RETURNING varchar2(100) NULL ON ERROR),'yyyy-mm-dd') ISSUE_DATE,
                NULL EXPIRY_DATE,
                NULL LICENSE_APPLICATION_ID,
                'فعالة' STATUS_DESC_A,
                'Valid' STATUS_DESC_E,
                   '' REMARKS,
                   '' JOURNEY_REF_NO
            FROM
                VLS_ISSUE_VEHI_STATUS_RPT_JRN.TRN_APPLICATION   IVS,
                TF_STP_TRAFFIC_FILES                            TF
            WHERE
                TF.TRAFFIC_NO = JSON_VALUE (IVS.CUSTOMER_INFO,'$.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR)
                AND JSON_VALUE (IVS.CUSTOMER_INFO,'$.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR) = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
                AND IVS.STATUS = 'COMPLETED'
                AND IVS.ACTIVE_PHASE = 'COMPLETED'
		    UNION
            SELECT
                TF.ID TRAFFIC_FILE_ID,
                '' || JSON_VALUE(IVS.APPLICATION_CRITERIA,'$.parameters.paymentRefNo' RETURNING NUMBER NULL ON ERROR) REFERENCE_NO,
                JSON_VALUE(IVS.APPLICATION_CRITERIA,'$.parameters.paymentRefNo' RETURNING NUMBER NULL ON ERROR) AS TRS_ID,
                NULL VLE_ID,
                'تقرير حالة المركبة' CERTIFICATE_TYPE_A,
                'Vehicle Status Report' CERTIFICATE_TYPE_E,
                2701 SVC_CODE,
                2 STATUS,
                F_GET_TRF_OWNER_NAME_A (tf.id) RELATED_TO_A,
                F_GET_TRF_OWNER_NAME_E (tf.id) RELATED_TO_E,
                TO_DATE(JSON_VALUE(IVS.APPLICATION_CRITERIA, '$.parameters.issueDate' RETURNING varchar2(100) NULL ON ERROR),'yyyy-mm-dd') ISSUE_DATE,
                NULL EXPIRY_DATE,
                NULL LICENSE_APPLICATION_ID,
                'فعالة' STATUS_DESC_A,
                'Valid' STATUS_DESC_E,
                   '' REMARKS,
                   '' JOURNEY_REF_NO
            FROM
                VLS_ISSUE_VEHI_STATUS_RPT_JRN.TRN_APPLICATION   IVS,
                TF_STP_TRAFFIC_FILES                            TF
            WHERE
                TF.TRAFFIC_NO = JSON_VALUE (IVS.CUSTOMER_INFO,'$.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR)
                AND JSON_VALUE (IVS.CUSTOMER_INFO,'$.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR) = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
                AND IVS.STATUS = 'UNDER_PROCESSING'
                AND IVS.ACTIVE_PHASE in ('SUBMIT_VEHICLE_REPORT_REQUEST', 'WAITING_VEHICLE_REPORT')
           /*
          UNION
          select DISTINCT
              TF.ID TRAFFIC_FILE_ID,
              TO_CHAR(JSON_VALUE(PRODUCT_DOCUMENT, '$.referenceNumber' RETURNING NUMBER NULL ON ERROR)) REFERENCE_NO,
              NULL AS TRS_ID,
              NULL AS VLE_ID,
              'اتفاقية شراء لوحة' CERTIFICATE_TYPE_A,
              'Sell Plate Purchase Agreement' CERTIFICATE_TYPE_E,
              2023 SVC_CODE,
              2 AS STATUS,
              F_GET_TRF_OWNER_NAME_A (tf.id) RELATED_TO_A,
              F_GET_TRF_OWNER_NAME_E (tf.id) RELATED_TO_E,
              to_date(JSON_VALUE(PRODUCT_DOCUMENT, '$.issueDate' RETURNING varchar2(100) NULL ON ERROR),'yyyy-mm-dd') ISSUE_DATE,
              NULL EXPIRY_DATE,
              NULL LICENSE_APPLICATION_ID,
              'فعالة' STATUS_DESC_A,
              'Valid' STATUS_DESC_E,
                   '' REMARKS,
                   '' JOURNEY_REF_NO
          from pls_traffic_plate.SELL_PURCHASE_AGREEMENT SEPA,
               TF_STP_TRAFFIC_FILES TF
          where tf.traffic_no = JSON_VALUE(PRODUCT_DOCUMENT, '$.buyerDetails.summaryInfo.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR)
            AND JSON_VALUE(PRODUCT_DOCUMENT, '$.buyerDetails.summaryInfo.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR) = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
          UNION
          select DISTINCT
              TF.ID TRAFFIC_FILE_ID,
              TO_CHAR(JSON_VALUE(PRODUCT_DOCUMENT, '$.referenceNumber' RETURNING NUMBER NULL ON ERROR)) REFERENCE_NO,
              NULL AS TRS_ID,
              NULL AS VLE_ID,
              'اتفاقية شراء لوحة' CERTIFICATE_TYPE_A,
              'Sell Plate Purchase Agreement' CERTIFICATE_TYPE_E,
              2023 SVC_CODE,
              2 AS STATUS,
              F_GET_TRF_OWNER_NAME_A (tf.id) RELATED_TO_A,
              F_GET_TRF_OWNER_NAME_E (tf.id) RELATED_TO_E,
              to_date(JSON_VALUE(PRODUCT_DOCUMENT, '$.issueDate' RETURNING varchar2(100) NULL ON ERROR),'yyyy-mm-dd') ISSUE_DATE,
              NULL EXPIRY_DATE,
              NULL LICENSE_APPLICATION_ID,
              'فعالة' STATUS_DESC_A,
              'Valid' STATUS_DESC_E,
                   '' REMARKS,
                   '' JOURNEY_REF_NO
          from pls_traffic_plate.SELL_PURCHASE_AGREEMENT SEPA,
               TF_STP_TRAFFIC_FILES TF
          where tf.traffic_no = JSON_VALUE(PRODUCT_DOCUMENT, '$.sellerDetails.summaryInfo.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR)
            AND JSON_VALUE(PRODUCT_DOCUMENT, '$.sellerDetails.summaryInfo.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR) = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
           */
           /* UNION
             SELECT
                 TF.ID TRAFFIC_FILE_ID,
                 JSON_VALUE(OCVJ.APPLICATION_CRITERIA,'$.parameters.cisTrsId') REFERENCE_NO,
                 NULL TRS_ID,
                 NULL VLE_ID,
                 'شهادة فحص مركبة' CERTIFICATE_TYPE_A,
                 'Vehicle Inspection Certificate' CERTIFICATE_TYPE_E,
                 20240 SVC_CODE,
                 2 STATUS,
                 F_GET_TRF_OWNER_NAME_A (tf.id) RELATED_TO_A,
                 F_GET_TRF_OWNER_NAME_E (tf.id) RELATED_TO_E,
                 trunc(OCVJ.status_date) ISSUE_DATE,
                 NULL EXPIRY_DATE,
                 NULL LICENSE_APPLICATION_ID,
                 'فعالة' STATUS_DESC_A,
                 'Valid' STATUS_DESC_E,
                  CASE WHEN OCVJ.ACTIVE_PHASE = 'APPROVED' THEN 'APPROVED'
                       WHEN OCVJ.ACTIVE_PHASE = 'REJECTED' THEN 'REJECTED'
                      END REMARKS,
                  OCVJ.APPLICATION_REF_NO JOURNEY_REF_NO
             FROM
                 VLS_OUTSIDE_CNT_INSPECTION_JRN.TRN_APPLICATION   OCVJ,
                 TF_STP_TRAFFIC_FILES                            TF
             WHERE
                 TF.TRAFFIC_NO = JSON_VALUE (OCVJ.CUSTOMER_INFO,'$.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR)
                 AND JSON_VALUE (OCVJ.CUSTOMER_INFO,'$.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR) =  LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
                 AND OCVJ.STATUS = 'COMPLETED'
                 AND OCVJ.ACTIVE_PHASE IN ('REJECTED','APPROVED')
                 */
         UNION
             SELECT
                 TF.ID TRAFFIC_FILE_ID,
                 JSON_VALUE(OCVJ.APPLICATION_CRITERIA,'$.parameters.cisTrsId') REFERENCE_NO,
                 NULL TRS_ID,
                 NULL VLE_ID,
                 'شهادة فحص مركبة' CERTIFICATE_TYPE_A,
                 'Vehicle Inspection Certificate' CERTIFICATE_TYPE_E,
                 20240 SVC_CODE,
                 2 STATUS,
                 F_GET_TRF_OWNER_NAME_A (tf.id) RELATED_TO_A,
                 F_GET_TRF_OWNER_NAME_E (tf.id) RELATED_TO_E,
                 trunc(OCVJ.status_date) ISSUE_DATE,
                 NULL EXPIRY_DATE,
                 NULL LICENSE_APPLICATION_ID,
                 'فعالة' STATUS_DESC_A,
                 'Valid' STATUS_DESC_E,
                 'PENDING' REMARKS,
                  OCVJ.APPLICATION_REF_NO JOURNEY_REF_NO
             FROM
                 VLS_OUTSIDE_CNT_INSPECTION_JRN.TRN_APPLICATION   OCVJ,
                 TF_STP_TRAFFIC_FILES                            TF
             WHERE
                 TF.TRAFFIC_NO = JSON_VALUE (OCVJ.CUSTOMER_INFO,'$.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR)
                 AND JSON_VALUE (OCVJ.CUSTOMER_INFO,'$.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR) =  LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
                 AND OCVJ.STATUS = 'UNDER_PROCESSING'
                 AND OCVJ.ACTIVE_PHASE IN ('WAITING_SUPERVISOR_APPROVAL')
          UNION
          SELECT
              TF.ID TRAFFIC_FILE_ID,
              JSON_VALUE(OCVJ.APPLICATION_CRITERIA,'$.parameters.cisTrsId') REFERENCE_NO,
              NULL TRS_ID,
              NULL VLE_ID,
              'شهادة فحص مركبة' CERTIFICATE_TYPE_A,
              'Vehicle Inspection Certificate' CERTIFICATE_TYPE_E,
              20240 SVC_CODE,
              2 STATUS,
              F_GET_TRF_OWNER_NAME_A (tf.id) RELATED_TO_A,
              F_GET_TRF_OWNER_NAME_E (tf.id) RELATED_TO_E,
              trunc(OCVJ.status_date) ISSUE_DATE,
              NULL EXPIRY_DATE,
              NULL LICENSE_APPLICATION_ID,
              'فعالة' STATUS_DESC_A,
              'Valid' STATUS_DESC_E,
              'PENDING' REMARKS,
              OCVJ.APPLICATION_REF_NO JOURNEY_REF_NO
          FROM
              VLS_OUTSIDE_CNT_INSPECTION_JRN.TRN_APPLICATION   OCVJ,
              TF_STP_TRAFFIC_FILES                            TF
          WHERE
              TF.TRAFFIC_NO = JSON_VALUE (OCVJ.CUSTOMER_INFO,'$.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR)
            AND JSON_VALUE (OCVJ.CUSTOMER_INFO,'$.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR) =  LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
            AND OCVJ.STATUS = 'UNDER_PROCESSING'
            AND OCVJ.ACTIVE_PHASE IN ('WAITING_SUPERVISOR_APPROVAL')
          UNION
          SELECT
              TF.ID TRAFFIC_FILE_ID,
              '' || JSON_VALUE(INCE.PRODUCT_DOCUMENT,'$.inspectionInfo.cisReferenceNo' RETURNING NUMBER NULL ON ERROR) REFERENCE_NO,
              JSON_VALUE(INCE.PRODUCT_DOCUMENT,'$.inspectionInfo.cisReferenceNo' RETURNING NUMBER NULL ON ERROR) AS TRS_ID,
              NULL VLE_ID,
              'شهادة فحص مركبة' CERTIFICATE_TYPE_A,
              'Vehicle Inspection Certificate' CERTIFICATE_TYPE_E,
              20240 SVC_CODE,
              2 STATUS,
              F_GET_TRF_OWNER_NAME_A (tf.id) RELATED_TO_A,
              F_GET_TRF_OWNER_NAME_E (tf.id) RELATED_TO_E,
              TO_DATE(JSON_VALUE(INCE.PRODUCT_DOCUMENT,'$.inspectionInfo.startDate' RETURNING varchar2(100) NULL ON ERROR),'yyyy-mm-dd') ISSUE_DATE,
              TO_DATE(JSON_VALUE(INCE.PRODUCT_DOCUMENT,'$.inspectionInfo.expiryDate' RETURNING varchar2(100) NULL ON ERROR),'yyyy-mm-dd') EXPIRY_DATE,
              NULL LICENSE_APPLICATION_ID,
              'فعالة' STATUS_DESC_A,
              'Valid' STATUS_DESC_E,
              'AVAILABLE' REMARKS,
              '' JOURNEY_REF_NO
          FROM  VLS_VEHICLE.REP_VEHICLE       VLE,
                VLS_INSPECTION.PRD_INSPECTION INCE,
                TF_STP_TRAFFIC_FILES          TF,
                TF_STP_VEHICLE_TESTS VHT
          WHERE VHT.CHASISS_NO = JSON_VALUE(VLE.PRODUCT_DOCUMENT, '$.vehicleInfo.vehicleSpecs.chassisNumber' RETURNING VARCHAR2(200) NULL ON ERROR)
            AND JSON_VALUE(VLE.PRODUCT_DOCUMENT, '$.customerInfo.rtaUnifiedNo' RETURNING NUMBER(15) NULL ON ERROR) = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
            AND TF.TRAFFIC_NO = JSON_VALUE (VLE.PRODUCT_DOCUMENT, '$.customerInfo.rtaUnifiedNo' RETURNING NUMBER(15) NULL ON ERROR)
            AND JSON_VALUE(INCE.PRODUCT_DOCUMENT, '$.vehicleSpecs.chassisNumber' RETURNING VARCHAR2(200) NULL ON ERROR) =
                JSON_VALUE(VLE.PRODUCT_DOCUMENT, '$.vehicleInfo.vehicleSpecs.chassisNumber' RETURNING VARCHAR2(200) NULL ON ERROR)
            AND VHT.TEST_DATE + 30 >= TRUNC(SYSDATE)
            AND VHT.CREATED_BY in('cis_user', 'SYNC_SYSTEM')
          /*UNION
          SELECT
              TF.ID TRAFFIC_FILE_ID,
              JSON_VALUE (SERE.SERVICE_DOCUMENT,'$.parameters.certificateInfo.referenceNumber') REFERENCE_NO,
              NULL TRS_ID,
              NULL VLE_ID,
              'شهادة حيازة مركبة' CERTIFICATE_TYPE_A,
              'Possession Certificate' CERTIFICATE_TYPE_E,
              205 SVC_CODE,
              2 STATUS,
              F_GET_TRF_OWNER_NAME_A (tf.id) RELATED_TO_A,
              F_GET_TRF_OWNER_NAME_E (tf.id) RELATED_TO_E,
              trunc(APPL.status_date) ISSUE_DATE,
              NULL EXPIRY_DATE,
              NULL LICENSE_APPLICATION_ID,
              'فعالة' STATUS_DESC_A,
              'Valid' STATUS_DESC_E,
              'PENDING' REMARKS,
              APPL.APPLICATION_REF_NO JOURNEY_REF_NO
          FROM VLS_DE_REGISTER_VEHICLE.TRN_APPLICATION APPL,
               VLS_VEHICLE_LICENSE.TRN_SERVICE_REQUEST  SERE,
               TF_STP_TRAFFIC_FILES TF,
               VLS_DE_REGISTER_VEHICLE.SCT_APPLICATION_TYPE APTY
          WHERE APPL.APPLICATION_REF_NO = SERE.APPLICATION_REF_NO
            AND SERE.SERVICE_CODE = 'VLC-004'
            AND APTY.ID = APPL.APPLICATION_TYPE_ID
            AND APTY.CODE = 'POSSESSION_VEHICLE'
            AND TF.TRAFFIC_NO = JSON_VALUE (APPL.CUSTOMER_INFO,'$.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR)
            AND JSON_VALUE (APPL.CUSTOMER_INFO,'$.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR) =  LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
            AND APPL.STATUS = 'UNDER_PROCESSING'
            AND APPL.ACTIVE_PHASE IN ('RECEIVE_PLATE_FROM_CUSTOMER', 'PLATE_DELIVERY')
          UNION
          SELECT
              TF.ID TRAFFIC_FILE_ID,
              JSON_VALUE (SERE.SERVICE_DOCUMENT,'$.parameters.certificateInfo.referenceNumber') REFERENCE_NO,
              NULL TRS_ID,
              NULL VLE_ID,
              'شهادة تصدير' CERTIFICATE_TYPE_A,
              'Export Certificate' CERTIFICATE_TYPE_E,
              206 SVC_CODE,
              2 STATUS,
              F_GET_TRF_OWNER_NAME_A (tf.id) RELATED_TO_A,
              F_GET_TRF_OWNER_NAME_E (tf.id) RELATED_TO_E,
              trunc(APPL.status_date) ISSUE_DATE,
              NULL EXPIRY_DATE,
              NULL LICENSE_APPLICATION_ID,
              'فعالة' STATUS_DESC_A,
              'Valid' STATUS_DESC_E,
              'PENDING' REMARKS,
              APPL.APPLICATION_REF_NO JOURNEY_REF_NO
          FROM VLS_DE_REGISTER_VEHICLE.TRN_APPLICATION APPL,
               VLS_VEHICLE_LICENSE.TRN_SERVICE_REQUEST  SERE,
               TF_STP_TRAFFIC_FILES TF,
               VLS_DE_REGISTER_VEHICLE.SCT_APPLICATION_TYPE APTY
          WHERE APPL.APPLICATION_REF_NO = SERE.APPLICATION_REF_NO
            AND SERE.SERVICE_CODE = 'VLC-004'
            AND APTY.ID = APPL.APPLICATION_TYPE_ID
            AND APTY.CODE = 'EXPORT_VEHICLE'
            AND TF.TRAFFIC_NO = JSON_VALUE (APPL.CUSTOMER_INFO,'$.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR)
            AND JSON_VALUE (APPL.CUSTOMER_INFO,'$.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR) =  LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
            AND JSON_VALUE (APPL.APPLICATION_CRITERIA,'$.parameters.exportType' RETURNING VARCHAR2(200) NULL ON ERROR) = 'EXPORT_TO_COUNTRY'
            AND APPL.STATUS = 'UNDER_PROCESSING'
            AND APPL.ACTIVE_PHASE IN ('PLATE_DELIVERY', 'RECEIVE_PLATE_FROM_CUSTOMER')
          UNION
          SELECT
              TF.ID TRAFFIC_FILE_ID,
              JSON_VALUE (SERE.SERVICE_DOCUMENT,'$.parameters.certificateInfo.referenceNumber') REFERENCE_NO,
              NULL TRS_ID,
              NULL VLE_ID,
              'شهادة تحويل' CERTIFICATE_TYPE_A,
              'Transfer Certificate' CERTIFICATE_TYPE_E,
              207 SVC_CODE,
              2 STATUS,
              F_GET_TRF_OWNER_NAME_A (tf.id) RELATED_TO_A,
              F_GET_TRF_OWNER_NAME_E (tf.id) RELATED_TO_E,
              trunc(APPL.status_date) ISSUE_DATE,
              NULL EXPIRY_DATE,
              NULL LICENSE_APPLICATION_ID,
              'فعالة' STATUS_DESC_A,
              'Valid' STATUS_DESC_E,
              'PENDING' REMARKS,
              APPL.APPLICATION_REF_NO JOURNEY_REF_NO
          FROM VLS_DE_REGISTER_VEHICLE.TRN_APPLICATION APPL,
               VLS_VEHICLE_LICENSE.TRN_SERVICE_REQUEST  SERE,
               TF_STP_TRAFFIC_FILES TF,
               VLS_DE_REGISTER_VEHICLE.SCT_APPLICATION_TYPE APTY
          WHERE APPL.APPLICATION_REF_NO = SERE.APPLICATION_REF_NO
            AND SERE.SERVICE_CODE = 'VLC-004'
            AND APTY.ID = APPL.APPLICATION_TYPE_ID
            AND APTY.CODE = 'EXPORT_VEHICLE'
            AND TF.TRAFFIC_NO = JSON_VALUE (APPL.CUSTOMER_INFO,'$.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR)
            AND JSON_VALUE (APPL.CUSTOMER_INFO,'$.rtaUnifiedNo' RETURNING NUMBER NULL ON ERROR) =  LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
            AND JSON_VALUE (APPL.APPLICATION_CRITERIA,'$.parameters.exportType' RETURNING VARCHAR2(200) NULL ON ERROR) = 'EXPORT_TO_EMIRATE'
            AND APPL.STATUS = 'UNDER_PROCESSING'
            AND APPL.ACTIVE_PHASE IN ('PLATE_DELIVERY', 'RECEIVE_PLATE_FROM_CUSTOMER')*/
            UNION
                SELECT TF.ID
                     TRAFFIC_FILE_ID,
                 TO_CHAR (CPL.ID)
                     REFERENCE_NO,
                 TRS.ID
                     TRS_ID,
                 bkt.vle_id
                     VLE_ID,
                 TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (
                     TRS.ID,
                     TRS.SVC_CODE_VHL).AR_VAL
                     CERTIFICATE_TYPE_A,
                 TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (
                     TRS.ID,
                     TRS.SVC_CODE_VHL).EN_VAL
                     CERTIFICATE_TYPE_E,
                 TRS.SVC_CODE_VHL
                     SVC_CODE,
                 1
                     STATUS,
                 TRAFFIC.F_GET_TRF_OWNER_NAME_A (tf.id)
                     RELATED_TO_A,
                 TRAFFIC.F_GET_TRF_OWNER_NAME_E (tf.id)
                     RELATED_TO_E,
                 CPL.REF_DATE
                     ISSUE_DATE,
                 NULL
                     EXPIRY_DATE,
                 NULL
                     LICENSE_APPLICATION_ID,
                 TRAFFIC.PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC (
                     'TF_ECERTIFICATE_STATUS',
                     1)
                     STATUS_DESC_A,
                 TRAFFIC.PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC_E (
                     'TF_ECERTIFICATE_STATUS',
                     1)
                     STATUS_DESC_E,
                 ''
                     REMARKS,
                 ''
                     JOURNEY_REF_NO
            FROM TRAFFIC.TF_VHL_BOOKLETS              BKT,
                 TRAFFIC.TF_VHL_CERTIFICATE_PRINT_LOGS CPL,
                 TRAFFIC.TF_STP_TRAFFIC_FILES         TF,
                 TRAFFIC.TF_STP_TRANSACTIONS          TRS
           WHERE     TRS.ID = CPL.RELATED_TRS_ID
                 AND TRS.ID = BKT.RELATED_TRS_ID
                 AND BKT.TRF_ID <> TF.ID
                 AND TF.PRS_ID = TRS.PRS_ID
                 AND TRS.STATUS = 3
                 AND TRS.SVC_CODE_vhl IN (206)
                 AND bkt.trs_start_date >=
                     (SELECT MAX (bkt2.trs_start_date)
                        FROM TF_VHL_BOOKLETS bkt2, tf_vhl_vehicles vle
                       WHERE bkt2.vle_id = vle.id AND bkt.vle_id = vle.id)
                 AND TF.TRAFFIC_NO = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
            UNION
                SELECT TF.ID
                     TRAFFIC_FILE_ID,
                 TO_CHAR (CPL.ID)
                     REFERENCE_NO,
                 TRS.ID
                     TRS_ID,
                 bkt.vle_id
                     VLE_ID,
                 TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (
                     TRS.ID,
                     TRS.SVC_CODE_VHL).AR_VAL
                     CERTIFICATE_TYPE_A,
                 TRAFFIC.PKG_NAME_AND_DESC.F_GET_ACTIVE_SVC_CODE_DESC (
                     TRS.ID,
                     TRS.SVC_CODE_VHL).EN_VAL
                     CERTIFICATE_TYPE_E,
                 TRS.SVC_CODE_VHL
                     SVC_CODE,
                 1
                     STATUS,
                 TRAFFIC.F_GET_TRF_OWNER_NAME_A (tf.id)
                     RELATED_TO_A,
                 TRAFFIC.F_GET_TRF_OWNER_NAME_E (tf.id)
                     RELATED_TO_E,
                 CPL.REF_DATE
                     ISSUE_DATE,
                 NULL
                     EXPIRY_DATE,
                 NULL
                     LICENSE_APPLICATION_ID,
                 TRAFFIC.PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC (
                     'TF_ECERTIFICATE_STATUS',
                     1)
                     STATUS_DESC_A,
                 TRAFFIC.PKG_DB_MIL_CORE_TOOLS.F_DB_GET_REF_CODE_DESC_E (
                     'TF_ECERTIFICATE_STATUS',
                     1)
                     STATUS_DESC_E,
                 ''
                     REMARKS,
                 ''
                     JOURNEY_REF_NO
            FROM TRAFFIC.TF_VHL_BOOKLETS              BKT,
                 TRAFFIC.TF_VHL_CERTIFICATE_PRINT_LOGS CPL,
                 TRAFFIC.TF_STP_TRAFFIC_FILES         TF,
                 TRAFFIC.TF_STP_TRANSACTIONS          TRS
           WHERE     TRS.ID = CPL.RELATED_TRS_ID
                 AND TRS.ID = BKT.RELATED_TRS_ID
                 AND BKT.TRF_ID <> TF.ID
                 AND TF.ORG_ID = TRS.ORG_ID
                 AND TRS.STATUS = 3
                 AND TRS.SVC_CODE_vhl IN (206)
                 AND bkt.trs_start_date >=
                     (SELECT MAX (bkt2.trs_start_date)
                        FROM TF_VHL_BOOKLETS bkt2, tf_vhl_vehicles vle
                       WHERE bkt2.vle_id = vle.id AND bkt.vle_id = vle.id)
                 AND TF.TRAFFIC_NO = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
          UNION
          SELECT TRF.ID TRAFFIC_FILE_ID,
                 TO_CHAR(PPL.PERMIT_NO) REFERENCE_NO,
                 SPM.TRS_ID TRS_ID,
                 NULL VLE_ID,
                 PETY.NAME_A CERTIFICATE_TYPE_A,
                 PETY.NAME_E CERTIFICATE_TYPE_E,
                 124 SVC_CODE,
                 SPM.STATUS,
                 PRS.NAME_A RELATED_TO_A,
                 PRS.NAME_E RELATED_TO_E,
                 SPM.ISSUE_DATE,
                 SPM.EXPIRY_DATE,
                 SPM.PERMIT_TYPE LICENSE_APPLICATION_ID,
                 'فعالة' STATUS_DESC_A,
                 'Valid' STATUS_DESC_E,
                 '' REMARKS,
                 DPR.APPLICATION_REF_NO JOURNEY_REF_NO
          FROM TF_STP_SP_PERMITS_PRINTING_LOG PPL,
               TF_STP_SPECIAL_PERMITS SPM,
               TF_STP_PERMIT_TYPES PETY,
               TF_STP_TRAFFIC_FILES TRF,
               TF_STP_PERSONS PRS,
               TF_STP_ORGANIZATIONS ORG,
               TF_DRL_DRIVING_LICENSES DLC,
               TF_STP_PERMIT_CATEGORIES PEC,
               TF_STP_PERMIT_TYPES PRY,
               DLS_VIEWS.DELIVERY_PERMIT_REPORT DPR
          WHERE PPL.SPM_ID = SPM.ID
            AND PPL.ID = (SELECT MAX(PPL2.ID) FROM TF_STP_SP_PERMITS_PRINTING_LOG PPL2 WHERE PPL2.PERMIT_NO = SPM.PERMIT_NO)
            AND SPM.TRF_ID = TRF.ID
            AND SPM.PERMIT_TYPE = PETY.ID
            AND ORG.ID(+) = TRF.ORG_ID
            AND PRS.ID(+) = TRF.PRS_ID
            AND DLC.TRF_ID(+) = TRF.ID
            AND SPM.PEC_ID = PEC.ID(+)
            AND PRY.ID = PEC.PRY_ID
            AND TRF.TRAFFIC_NO = LS_UMS.PKG_UMS_PARAMS.F_GET_PARAM_VALUE ('PV_TRAFFIC_NO')
            AND DPR.TRAFFIC_FILE_NO = TRF.TRAFFIC_NO
            AND TRUNC(SPM.EXPIRY_DATE) > TRUNC(SYSDATE)
            AND SPM.PERMIT_TYPE = 10056
            AND SPM.PEC_ID in (28,916,23,449,1,1769,369,1770,3,2,22,4,89)
            ) RESULT
ORDER BY ISSUE_DATE DESC
