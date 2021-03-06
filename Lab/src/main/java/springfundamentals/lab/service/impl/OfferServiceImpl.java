package springfundamentals.lab.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springfundamentals.lab.domain.dto.OfferGetDto;
import springfundamentals.lab.domain.dto.OfferSetDto;
import springfundamentals.lab.domain.entity.Category;
import springfundamentals.lab.domain.entity.Engine;
import springfundamentals.lab.domain.entity.Offer;
import springfundamentals.lab.domain.entity.Transmission;
import springfundamentals.lab.repository.ModelRepository;
import springfundamentals.lab.repository.OfferRepository;
import springfundamentals.lab.repository.UserRepository;
import springfundamentals.lab.service.OfferService;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper mapper;

    public OfferServiceImpl(OfferRepository offerRepository, UserRepository userRepository,
                            ModelRepository modelRepository, ModelMapper mapper) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public void addNewOffer(OfferSetDto offerSetDto) {
        Offer newOffer = this.mapper.map(offerSetDto, Offer.class);
        newOffer.setCategory(Category.valueOf(offerSetDto.getCategory()));
        newOffer.setEngine(Engine.valueOf(offerSetDto.getEngine()));
        newOffer.setTransmission(Transmission.valueOf(offerSetDto.getTransmission()));
        newOffer.setCreated(new Date());
        newOffer.setModified(new Date());
        newOffer.setModel(this.modelRepository.findByName(offerSetDto.getModel()));
        newOffer.setSeller(this.userRepository.findByUsername(offerSetDto.getSeller()));

        this.offerRepository.saveAndFlush(newOffer);
    }

    @Override
    public List<OfferGetDto> getAllOffers() {

        return this.offerRepository.findAll().stream()
                .map(o -> this.mapper.map(o, OfferGetDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public OfferGetDto findById(long id) {
        return this.mapper.map(offerRepository.findById(id), OfferGetDto.class);
    }
}
