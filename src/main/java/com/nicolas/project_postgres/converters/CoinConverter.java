package com.nicolas.project_postgres.converters;

import com.nicolas.project_postgres.dtos.CoinDTO;
import com.nicolas.project_postgres.models.Coin;

public class CoinConverter extends AbstractConverter<Coin, CoinDTO> {
    @Override
    public CoinDTO fromEntity(Coin entity) {
        if (entity == null) return null;
        return CoinDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public Coin fromDTO(CoinDTO dto) {
        if (dto == null) return null;
        return Coin.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
